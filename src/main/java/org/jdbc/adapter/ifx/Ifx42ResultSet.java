package org.jdbc.adapter.ifx;

import java.sql.ResultSet;

import org.jdbc.adapter.iface.StatementWrapper;
import org.jdbc.adapter.jdbc42.Jdbc42ResultSet;

/**
 * @author David Matějček
 */
public class Ifx42ResultSet extends Jdbc42ResultSet {

  public Ifx42ResultSet(final ResultSet resultSet, final StatementWrapper parentStatement) {
    super(resultSet, parentStatement);
  }
}
