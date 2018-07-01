package com.rabobank.cst.dto;

/**
 * @author Bala
 *
 */
public class CustomerTransactionDTO {

	private String refereceId;
	private String accountNo;
	private String description;
	private String startBalance;
	private String mutation;
	private String endBalance;

	/**
	 * @return the refereceId
	 */
	public String getRefereceId() {
		return refereceId;
	}

	/**
	 * @param refereceId
	 *            the refereceId to set
	 */
	public void setRefereceId(String refereceId) {
		this.refereceId = refereceId;
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
	public String getStartBalance() {
		return startBalance;
	}

	/**
	 * @param startBalance
	 *            the startBalance to set
	 */
	public void setStartBalance(String startBalance) {
		this.startBalance = startBalance;
	}

	/**
	 * @return the mutation
	 */
	public String getMutation() {
		return mutation;
	}

	/**
	 * @param mutation
	 *            the mutation to set
	 */
	public void setMutation(String mutation) {
		this.mutation = mutation;
	}

	/**
	 * @return the endBalance
	 */
	public String getEndBalance() {
		return endBalance;
	}

	/**
	 * @param endBalance
	 *            the endBalance to set
	 */
	public void setEndBalance(String endBalance) {
		this.endBalance = endBalance;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerTransactionDTO [refereceId=" + refereceId + ", accountNo=" + accountNo + ", description="
				+ description + ", startBalance=" + startBalance + ", mutation=" + mutation + ", endBalance="
				+ endBalance + "]";
	}

}