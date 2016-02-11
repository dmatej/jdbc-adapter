package org.jdbc.adapter.ifx;

import org.jdbc.adapter.test.Helper;
import org.junit.Test;

import com.informix.jdbcx.IfxDataSource;

/**
 * @author David Matějček
 */
public class InformixDataSourceTest {

  @Test
  public void compareDriverApi() {
    Helper.compareApi(Ifx42DataSource.class, IfxDataSource.class);
  }
}
