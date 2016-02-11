package org.jdbc.adapter.derby;

import java.sql.Connection;
import java.util.Hashtable;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.Name;

import org.apache.derby.jdbc.EmbeddedDataSource;
import org.jdbc.adapter.jdbc42.Jdbc42DataSource;

/**
 * @author David Matějček
 */
public class Derby42EmbeddedDataSource extends Jdbc42DataSource<EmbeddedDataSource> {

  private static final Logger LOG = Logger.getLogger(Derby42EmbeddedDataSource.class.getName());
  private static final long serialVersionUID = -7596739358170400856L;


  public Derby42EmbeddedDataSource() {
    super();
  }


  public Derby42EmbeddedDataSource(final EmbeddedDataSource ds) {
    super(ds);
  }


  @Override
  public String getDriverClassName() {
    return "org.apache.derby.jdbc.Driver42";
  }


  @Override
  public String getDataSourceClassName() {
    return "org.apache.derby.jdbc.EmbeddedDataSource";
  }


  @Override
  protected Connection wrapConnection(final Connection connection) {
    LOG.fine("Wrapping the connection " + connection + " to " + Derby42Connection.class.getName());
    return new Derby42Connection(connection);
  }


  public Object getObjectInstance(final Object o, final Name n, final Context c, final Hashtable h) throws Exception {
    return this.datasource.getObjectInstance(o, n, c, h);
  }


  public String getPassword() {
    return this.datasource.getPassword();
  }


  public String getDescription() {
    return this.datasource.getDescription();
  }


  public synchronized void setDatabaseName(final String s) {
    this.datasource.setDatabaseName(s);
  }


  public String getDatabaseName() {
    return this.datasource.getDatabaseName();
  }


  public void setDataSourceName(final String s) {
    this.datasource.setDataSourceName(s);
  }


  public String getDataSourceName() {
    return this.datasource.getDataSourceName();
  }


  public void setDescription(final String s) {
    this.datasource.setDescription(s);
  }


  public void setUser(final String s) {
    this.datasource.setUser(s);
  }


  public String getUser() {
    return this.datasource.getUser();
  }


  public void setPassword(final String s) {
    this.datasource.setPassword(s);
  }


  public void setCreateDatabase(final String s) {
    this.datasource.setCreateDatabase(s);
  }


  public String getCreateDatabase() {
    return this.datasource.getCreateDatabase();
  }


  public void setConnectionAttributes(final String s) {
    this.datasource.setConnectionAttributes(s);
  }


  public String getConnectionAttributes() {
    return this.datasource.getConnectionAttributes();
  }


  public void setShutdownDatabase(final String s) {
    this.datasource.setShutdownDatabase(s);
  }


  public String getShutdownDatabase() {
    return this.datasource.getShutdownDatabase();
  }


  public void setAttributesAsPassword(final boolean s) {
    this.datasource.setAttributesAsPassword(s);
  }


  public boolean getAttributesAsPassword() {
    return this.datasource.getAttributesAsPassword();
  }
}
