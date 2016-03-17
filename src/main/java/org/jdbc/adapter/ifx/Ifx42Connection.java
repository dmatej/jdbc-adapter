package org.jdbc.adapter.ifx;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

import org.jdbc.adapter.iface.StatementWrapper;
import org.jdbc.adapter.jdbc42.Jdbc42Connection;

import com.informix.jdbc.IfmxConnection;

/**
 * @author David Matějček
 */
public class Ifx42Connection extends Jdbc42Connection {
  private static final Logger LOG = Logger.getLogger(Ifx42Connection.class.getName());

  public Ifx42Connection(final Connection connection) {
    super(connection);
  }


  /**
   * @param statement
   * @return a {@link Ifx42Statement} instance.
   */
  @Override
  public StatementWrapper wrap(final Statement statement) {
    if (statement == null) {
      return null;
    }
    return new Ifx42Statement(statement, this);
  }


  /**
   * @return the wrapped connection;
   */
  @Override
  protected final IfmxConnection getConnection() {
    return IfmxConnection.class.cast(getConnection());
  }


  /**
   * IFXJDBC does not support this method. This wrapper ignores it.
   */
  @Override
  public void setNetworkTimeout(final Executor executor, final int milliseconds) throws SQLException {
    LOG.warning("This driver does not support the setNetworkTimeout(Executor executor, int milliseconds)."
        + " Method call was ignored.");
  }


  /**
   * IFXJDBC does not support this method. This wrapper always returns 0 (no timeout).
   */
  @Override
  public int getNetworkTimeout() throws SQLException {
    return 0;
  }
}
