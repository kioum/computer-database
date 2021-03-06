package com.excilys.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.excilys.dto.CompanyDTO;
import com.excilys.model.Company;

import junit.framework.TestCase;

public class CompanyMapperTest extends TestCase{

	@Mock
	private ResultSet rs;

	@Override
	@Before
	public void setUp() throws SQLException {
		rs = Mockito.mock(ResultSet.class);
		Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
		Mockito.when(rs.getLong("id")).thenReturn(Long.valueOf(1));
		Mockito.doReturn("Test Company").when(rs).getString("name");
	}

	@Test
	public void testMap() throws SQLException {
		Company comp = CompanyMapper.map(rs);

		assertEquals(comp.getId(), 1L);
		assertEquals(comp.getName(), "Test Company");
	}

	@Test
	public void testMapDTO() throws SQLException {
		ArrayList<Company> comp = new ArrayList<Company>();
		comp.add(CompanyMapper.map(rs));
		
		List<CompanyDTO> compDTO = CompanyMapper.mapDTO(new ArrayList<Company>());
		assertEquals(compDTO.size(), 0);

		compDTO = CompanyMapper.mapDTO(comp);
		assertEquals(comp.size(), compDTO.size());
		assertEquals(comp.get(0).getId(), compDTO.get(0).getId());
		assertEquals(comp.get(0).getName(), compDTO.get(0).getName());

	}
}
