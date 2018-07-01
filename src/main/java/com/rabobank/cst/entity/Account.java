package com.rabobank.cst.entity;

/**
 * @author Bala
 *
 */
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "account")
public class Account extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id", updatable = false, nullable = false)
	private Long accountId;

	@Column(name = "account_no")
	private String accountNo;

	@OneToMany(mappedBy = "account", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	private Set<Transaction> transaction;

	@OneToMany(mappedBy = "account", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	private Set<ErrorTransaction> errorTransaction;

	/**
	 * @return the accountId
	 */
	public Long getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId
	 *            the accountId to set
	 */
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the accountNo
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * @param accountNo
	 *            the accountNo to set
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	/**
	 * @return the transaction
	 */
	public Set<Transaction> getTransaction() {
		return transaction;
	}

	/**
	 * @param transaction
	 *            the transaction to set
	 */
	public void setTransaction(Set<Transaction> transaction) {
		this.transaction = transaction;
	}

	/**
	 * @return the errorTransaction
	 */
	public Set<ErrorTransaction> getErrorTransaction() {
		return errorTransaction;
	}

	/**
	 * @param errorTransaction
	 *            the errorTransaction to set
	 */
	public void setErrorTransaction(Set<ErrorTransaction> errorTransaction) {
		this.errorTransaction = errorTransaction;
	}

	public void addTransaction(Transaction trans) {
		if (transaction == null) {
			transaction = new TreeSet<>();
		}
		transaction.add(trans);

	}

	public void addErrorTransaction(ErrorTransaction trans) {
		if (errorTransaction == null) {
			errorTransaction = new TreeSet<>();
		}
		errorTransaction.add(trans);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result + ((accountNo == null) ? 0 : accountNo.hashCode());
		result = prime * result + ((errorTransaction == null) ? 0 : errorTransaction.hashCode());
		result = prime * result + ((transaction == null) ? 0 : transaction.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Account other = (Account) obj;
		if (accountId == null) {
			if (other.accountId != null) {
				return false;
			}
		} else if (!accountId.equals(other.accountId)) {
			return false;
		}
		if (accountNo == null) {
			if (other.accountNo != null) {
				return false;
			}
		} else if (!accountNo.equals(other.accountNo)) {
			return false;
		}
		if (errorTransaction == null) {
			if (other.errorTransaction != null) {
				return false;
			}
		} else if (!errorTransaction.equals(other.errorTransaction)) {
			return false;
		}
		if (transaction == null) {
			if (other.transaction != null) {
				return false;
			}
		} else if (!transaction.equals(other.transaction)) {
			return false;
		}
		return true;
	}

}
