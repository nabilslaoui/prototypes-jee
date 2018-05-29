package com.slaoui.enterprise.prototypes.dao.springjdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.slaoui.enterprise.prototypes.dao.IEmployeDao;
import com.slaoui.enterprise.prototypes.dao.beans.EmployeAnnotated;

//@Repository("JdbcEmployeBisDao")
public class JdbcEmployeBisDao implements IEmployeDao {

	@Autowired
	private DataSource dataSource;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmployeAnnotated getEmployeById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			final String EMPLOYE_QUERY = "select  id, login, email, password, prenom, nom, role "
					+ " from employe where id=?";

			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(EMPLOYE_QUERY);

			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			EmployeAnnotated employe = null;
			if (rs.next()) {
				employe = new EmployeAnnotated();
				employe.setId(rs.getLong("id"));
				employe.setEmail(rs.getString("email"));
				employe.setPassword(rs.getString("password"));
				employe.setLogin(rs.getString("login"));
				employe.setNom(rs.getString("nom"));
				employe.setPrenom(rs.getString("prenom"));
				employe.setRole(rs.getString("role"));
			}

			return employe;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveEmploye(EmployeAnnotated employe) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			final String EMPLOYE_INSERT = "insert into employe (login, password, prenom, nom, email, role) "
					+ "values (?,?,?,?,?,?)";

			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(EMPLOYE_INSERT);

			// stmt.setInt(1, employe.getId());
			stmt.setString(1, employe.getLogin());
			stmt.setString(2, employe.getPassword());
			stmt.setString(3, employe.getPrenom());
			stmt.setString(4, employe.getNom());
			stmt.setString(5, employe.getEmail());
			stmt.setString(6, employe.getRole());

			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getEmployesCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<EmployeAnnotated> getAllEmployes() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmployeAnnotated getEmployeByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
