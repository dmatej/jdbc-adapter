package org.jdbc.adapter.derby;

import org.apache.derby.jdbc.EmbeddedDataSource;
import org.jdbc.adapter.test.Helper;
import org.junit.Test;

/**
 * @author David Matějček
 */
public class DerbyDataSourceTest {

  @Test
  public void compareDriverApi() {
    Helper.compareApi(Derby42EmbeddedDataSource.class, EmbeddedDataSource.class);
  }
}
