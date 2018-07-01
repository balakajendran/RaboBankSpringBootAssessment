package com.rabobank.cst.dto;

/**
 * @author Bala
 *
 */
public class CustomerErrorTransaction {
	private Long referenceId;
	private String accountNo;
	private float startBalance;
	private float mutation;
	private float endBalance;
	private String description;
	private String errorDetails;
	/**
	 * @return the referenceId
	 */
	public Long getReferenceId() {
		return referenceId;
	}
	/**
	 * @param referenceId the referenceId to set
	 */
	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}
	/**
	 * @return the accountNo
	 */
	public String getAccountNo() {
		return accountNo;
	}
	/**
	 * @param accountNo the accountNo to set
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	/**
	 * @return the startBalance
	 */
	public float getStartBalance() {
		return startBalance;
	}
	/**
	 * @param startBalance the startBalance to set
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
	 * @param mutation the mutation to set
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
	 * @param endBalance the endBalance to set
	 */
	public void setEndBalance(float endBalance) {
		this.endBalance = endBalance;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the errorDetails
	 */
	public String getErrorDetails() {
		return errorDetails;
	}
	/**
	 * @param errorDetails the errorDetails to set
	 */
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

}
