package com.example.dao;

import java.util.Date;
import java.util.List;

import com.example.bean.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ActivityDaoImpl implements ActivityDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Transaction> findTransactionsByCashAccountNumber(final String number) {
		/*
		String sql = "SELECT * FROM transaction WHERE number = '" + number + "'";

		List<Transaction> customers = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Transaction.class));
		*/

		String sql = "SELECT * FROM transaction WHERE number = ?";

		List<Transaction> customers = jdbcTemplate.query(sql,
			new Object[] { number },
			new int[] { java.sql.Types.INTEGER },
			BeanPropertyRowMapper.newInstance(Transaction.class));

		return customers;
	}

	@Override
	public void insertNewActivity(final Date date, final String description, final String number, final double amount,
			final double availablebalance) {

		try {
			String sql = "INSERT INTO transaction " + "(date, description, number, amount, availablebalance) VALUES (?, ?, ?, ?, ?)";

			jdbcTemplate.update(sql, new Object[] { date, description, number, amount, availablebalance, });
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	public void setJdbcTemplate(final JdbcTemplate paramJdbcTemplate) {
		jdbcTemplate = paramJdbcTemplate;
	}

}
