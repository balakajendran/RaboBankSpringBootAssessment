package com.rabobank.cst.utility;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.rabobank.cst.dto.CustomerTransactionDTO;

/**
 * @author Bala
 *
 */
@Component
public class ValidationUtil {

	/**
	 * @param trans
	 * @return
	 */
	public static String validateTransaction(CustomerTransactionDTO trans) {

		if (null == trans.getStartBalance()) {
			return "Start Balance Not Available";
		}

		if (null == trans.getMutation()) {
			return "Mutation Not Available";
		}

		if (null == trans.getStartBalance()) {
			return "End Balance Not Available";
		}

		final float mutaion = Float.parseFloat(trans.getMutation());
		final float startBalance = Float.parseFloat(trans.getStartBalance());
		final float endBalance = Float.parseFloat(trans.getEndBalance());
		final float balance = startBalance + mutaion;
		BigDecimal fmtBalance = formatBalance(endBalance);
		BigDecimal fmtEndBalance = formatBalance(balance);
		if (fmtBalance.compareTo(fmtEndBalance)!=0) {
			return "End Balance is Incorrect";
		}

		return null;

	}
	
	public static BigDecimal formatBalance(float balance) {
		BigDecimal bd = new BigDecimal(Float.toString(balance));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        return bd;
	}
}
