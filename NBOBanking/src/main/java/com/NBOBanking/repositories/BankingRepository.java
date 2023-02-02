package com.NBOBanking.repositories;

import com.NBOBanking.Entities.BankAccount;
import com.NBOBanking.Entities.Transaction;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BankingRepository implements IBankingRepository {
    @Autowired
    private EntityManager em;

    @Autowired
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("employee-registrar");

    public boolean createTransactionRecord(Transaction newTransaction) {
        try {

            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(newTransaction);
            em.getTransaction().commit();
            em.close();

            return true;

        } catch(EntityExistsException ex) {

            em.close();
            return false;

        }
    }

    // Issue on Postman when trying to add new account
    public BankAccount createBankAccountRecord(BankAccount newBankAccount) {
        try {

            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(newBankAccount);
            em.getTransaction().commit();

        } catch(EntityExistsException ex) {

            em.close();
            return new BankAccount();

        }


        TypedQuery<BankAccount> query = em.createQuery("SELECT b FROM BankAccount b WHERE b.account_num = :account_num", BankAccount.class);

        query.setParameter("account_num", newBankAccount.account_num);

        try {

            BankAccount currBankAccount = query.getSingleResult();
            em.close();
            return currBankAccount;

        } catch(NoResultException ex) {

            em.close();
            return new BankAccount();

        }
    }

    public List<Transaction> getBankTransactions(int bankAccountId) {
        Query query = em.createQuery("SELECT t FROM Transaction t WHERE t.bankaccount_id = :bankAccountId", Transaction.class);

        query.setParameter("bankAccountId", bankAccountId);

        List<Transaction> transactions = (List<Transaction>) query.getResultList();

        em.close();

        return transactions;
    }

    public List<BankAccount> getBankAccounts(int userId) {
        Query query = em.createQuery("SELECT ba FROM BankAccount ba WHERE ba.user_id = :userId", BankAccount.class);

        query.setParameter("userId", userId);

        List<BankAccount> bankAccounts = (List<BankAccount>) query.getResultList();

        em.close();

        return bankAccounts;
    }

    public boolean updateBankAccountBalance(BankAccount updatedBalance) {
        try {

            BankAccount bankAccount = em.find(BankAccount.class, updatedBalance.bankaccount_id);

            em = emf.createEntityManager();
            em.getTransaction().begin();
            bankAccount.total_amount = updatedBalance.total_amount;
            em.merge(bankAccount);
            em.getTransaction().commit();

            em.close();
            return true;

        } catch(IllegalArgumentException ex) {

            em.close();
            return false;

        }
    }
}
