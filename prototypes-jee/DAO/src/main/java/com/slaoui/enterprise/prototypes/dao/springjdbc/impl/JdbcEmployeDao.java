package com.slaoui.enterprise.prototypes.dao.springjdbc.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.slaoui.enterprise.prototypes.dao.IEmployeDao;
import com.slaoui.enterprise.prototypes.dao.beans.EmployeAnnotated;

@Repository("JdbcEmployeDao")
public class JdbcEmployeDao implements IEmployeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 
	 * @param dataSource
	 *            dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmployeAnnotated getEmployeById(int id) {

		String sql = "select id, nom, prenom from employe where id = ?";

		// Mapping d'un enregistrement vers un ResultSet
		RowMapper mapper = new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmployeAnnotated employe = new EmployeAnnotated();
				employe.setId((Long) rs.getLong("id"));
				employe.setNom(rs.getString("nom"));
				employe.setPrenom(rs.getString("prenom"));
				return employe;
			}

		};
		// Retourne l'objet EmployeAnnotated associé à l'Id
		// Notez 1) le casting explicite EmployeAnnotated,
		// 2) que l'enveloppe de l'argument 'id' dans un tableau d'objet,
		// 3) le boxing de 'id' comme un type reference Long
		// Ces étapes ne sont pas necessaire en utilisant (java 5)
		// SimpleJdbcTemplate
		return (EmployeAnnotated) jdbcTemplate.queryForObject(sql, new Object[] { Long.valueOf(id) }, mapper);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmployeAnnotated getEmployeByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
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
	public int getEmployesCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveEmploye(EmployeAnnotated employe) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}