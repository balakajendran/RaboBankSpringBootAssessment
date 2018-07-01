package com.rabobank.cst.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Bala
 *
 */
@Entity
@Table(name = "transaction")
public class Transaction extends BaseTransaction implements Comparable<Transaction>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id", updatable = false, nullable = false)
	private Long transactionId;

	/**
	 * @return the transactionId
	 */
	public Long getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId
	 *            the transactionId to set
	 */
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
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
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
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
		final Transaction other = (Transaction) obj;
		if (transactionId == null) {
			if (other.transactionId != null) {
				return false;
			}
		} else if (!transactionId.equals(other.transactionId)) {
			return false;
		}
		return true;
	}

	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transaction [transactionId=");
		builder.append(transactionId);
		builder.append(", getReferenceId()=");
		builder.append(getReferenceId());
		builder.append(", getAccount()=");
		builder.append(getAccount());
		builder.append(", getDescription()=");
		builder.append(getDescription());
		builder.append(", getStartBalance()=");
		builder.append(getStartBalance());
		builder.append(", getMutation()=");
		builder.append(getMutation());
		builder.append(", getEndBalance()=");
		builder.append(getEndBalance());
		builder.append(", getCreatedDate()=");
		builder.append(getCreatedDate());
		builder.append(", getUpdatedDate()=");
		builder.append(getUpdatedDate());
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Transaction o) {
		if(o==null || this.transactionId == null || o.transactionId == null) {
			return 0;
		} 
		return Long.compare(this.transactionId, o.transactionId);
	}
	
	

}
