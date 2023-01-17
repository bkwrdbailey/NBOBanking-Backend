package com.NBOBanking.repositories;

import com.NBOBanking.Entities.BankAccount;
import com.NBOBanking.Entities.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankingRepository implements IBankingRepository {
    
    private EntityManagerFactory emFactory;

    public boolean createTransactionRecord(Transaction newTransaction) {

        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        em.persist(newTransaction);

        em.getTransaction().commit();
        em.close();
        emFactory.close();

        return false;
    }

    public BankAccount createBankAccountRecord(BankAccount newBankAccount) {

        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        em.persist(newBankAccount);

        em.getTransaction().commit();
        em.close();
        emFactory.close();

        return new BankAccount();
    }

    public List<Transaction> getBankTransactions(int bankAccountId) {

        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        List<Transaction> transactions = em.createQuery("SELECT t FROM Transactions t WHERE t.bankaccount_id = :bankAccountId", Transaction.class).getResultList();

        em.getTransaction().commit();
        em.close();
        emFactory.close();

        return transactions;
    }

    public List<BankAccount> getBankAccounts(int userId) {

        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        List<BankAccount> bankAccounts = em.createQuery("SELECT ba FROM Bank_Accounts ba WHERE ba.user_id = :userId ", BankAccount.class).getResultList();

        em.getTransaction().commit();
        em.close();
        emFactory.close();

        return bankAccounts;
    }

    public boolean updateBankAccountBalance(BankAccount updatedBalance) {

        EntityManager em = emFactory.createEntityManager();
        BankAccount bankAccount = em.find(BankAccount.class, updatedBalance.bankaccount_id);

        em.getTransaction().begin();
        bankAccount.total_amount = updatedBalance.total_amount;
        em.getTransaction().commit();

        em.close();
        emFactory.close();

        return true;
    }
}
