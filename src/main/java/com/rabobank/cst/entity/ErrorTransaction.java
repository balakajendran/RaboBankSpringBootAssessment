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
@Table(name = "error_transaction")
public class ErrorTransaction extends BaseTransaction implements Comparable<ErrorTransaction> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "error_transaction_id", updatable = false, nullable = false)
	private Long errorTransId;

	@Column(name = "error_details", nullable = false)
	private String errorDetails;

	/**
	 * @return the errorTransId
	 */
	public Long getErrorTransId() {
		return errorTransId;
	}

	/**
	 * @param errorTransId
	 *            the errorTransId to set
	 */
	public void setErrorTransId(Long errorTransId) {
		this.errorTransId = errorTransId;
	}

	/**
	 * @return the errorDetails
	 */
	public String getErrorDetails() {
		return errorDetails;
	}

	/**
	 * @param errorDetails
	 *            the errorDetails to set
	 */
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 0;
		try {
			result = super.hashCode();
		}catch (Exception e) {
			System.out.println(this.toString());
			e.printStackTrace();
		}
		result = prime * result + ((errorDetails == null) ? 0 : errorDetails.hashCode());
		result = prime * result + ((errorTransId == null) ? 0 : errorTransId.hashCode());
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
		final ErrorTransaction other = (ErrorTransaction) obj;
		if (errorDetails == null) {
			if (other.errorDetails != null) {
				return false;
			}
		} else if (!errorDetails.equals(other.errorDetails)) {
			return false;
		}
		if (errorTransId == null) {
			if (other.errorTransId != null) {
				return false;
			}
		} else if (!errorTransId.equals(other.errorTransId)) {
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
		builder.append("ErrorTransaction [errorTransId=");
		builder.append(errorTransId);
		builder.append(", errorDetails=");
		builder.append(errorDetails);
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
	public int compareTo(ErrorTransaction o) {
		if(o==null || this.errorTransId == null || o.errorTransId == null) {
			return 0;
		} 
		return Long.compare(this.errorTransId, o.errorTransId);
	}

}
