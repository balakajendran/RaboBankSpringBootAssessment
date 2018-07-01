package com.rabobank.cst.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * @author Bala
 *
 */
@MappedSuperclass
public class BaseTransaction extends BaseEntity {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "reference_id")
	private Long referenceId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	private Account account;

	@Column(name = "description", nullable = true)
	private String description;

	@Column(name = "start_balance", nullable = false)
	private float startBalance;

	@Column(name = "mutation", nullable = false)
	private float mutation;

	@Column(name = "end_balance", nullable = false)
	private float endBalance;

	/**
	 * @return the referenceId
	 */
	public Long getReferenceId() {
		return referenceId;
	}

	/**
	 * @param referenceId
	 *            the referenceId to set
	 */
	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + Float.floatToIntBits(endBalance);
		result = prime * result + Float.floatToIntBits(mutation);
		result = prime * result + ((referenceId == null) ? 0 : referenceId.hashCode());
		result = prime * result + Float.floatToIntBits(startBalance);
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
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final BaseTransaction other = (BaseTransaction) obj;
		if (account == null) {
			if (other.account != null) {
				return false;
			}
		} else if (!account.equals(other.account)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (Float.floatToIntBits(endBalance) != Float.floatToIntBits(other.endBalance)) {
			return false;
		}
		if (Float.floatToIntBits(mutation) != Float.floatToIntBits(other.mutation)) {
			return false;
		}
		if (referenceId == null) {
			if (other.referenceId != null) {
				return false;
			}
		} else if (!referenceId.equals(other.referenceId)) {
			return false;
		}
		if (Float.floatToIntBits(startBalance) != Float.floatToIntBits(other.startBalance)) {
			return false;
		}
		return true;
	}
	

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the startBalance
	 */
	public float getStartBalance() {
		return startBalance;
	}

	/**
	 * @param startBalance
	 *            the startBalance to set
	 */
	public void setStartBalance(float startBalance) {
		this.startBalance = startBalance;
	}

	/**
	 * @return the mutation
	 */
	public float getMutation() {
		return mutation;
	}

	/**
	 * @param mutation
	 *            the mutation to set
	 */
	public void setMutation(float mutation) {
		this.mutation = mutation;
	}

	/**
	 * @return the endBalance
	 */
	public float getEndBalance() {
		return endBalance;
	}

	/**
	 * @param endBalance
	 *            the endBalance to set
	 */
	public void setEndBalance(float endBalance) {
		this.endBalance = endBalance;
	}

}
