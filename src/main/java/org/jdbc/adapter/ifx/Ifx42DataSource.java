package org.jdbc.adapter.ifx;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

import org.jdbc.adapter.jdbc42.Jdbc42DataSource;

import com.informix.jdbcx.IfxConnectionPoolDataSource;
import com.informix.jdbcx.IfxDataSource;

/**
 * @author David Matějček
 */
public class Ifx42DataSource extends Jdbc42DataSource<IfxDataSource> {
  private static final Logger LOG = Logger.getLogger(Ifx42DataSource.class.getName());

  private static final long serialVersionUID = -7596739358170400856L;


  public Ifx42DataSource() {
    super();
  }


  public Ifx42DataSource(final IfxDataSource ds) {
    super(ds);
  }


  public Ifx42DataSource(final Properties ds) throws SQLException {
    super(createDataSource(ds));
  }


  private static IfxDataSource createDataSource(final Properties settings) throws SQLException {
    final IfxDataSource ds = new IfxDataSource();
    ds.getDsProperties().putAll(settings);
    return ds;
  }


  @Override
  public String getDriverClassName() {
    return "com.informix.jdbc.IfxDriver";
  }


  @Override
  public String getDataSourceClassName() {
    return "com.informix.jdbcx.IfxDataSource";
  }


  @Override
  protected Connection wrapConnection(final Connection connection) {
    LOG.fine("Wrapping the connection " + connection + " to " + Ifx42Connection.class.getName());
    return new Ifx42Connection(connection);
  }


  public int getCPMFreeCount() {
    return -1;
  }


  public IfxConnectionPoolDataSource getCPDS() {
    return null;
  }


  public void activateHDRPool_Primary() throws SQLException {
  }


  public void

  activateHDRPool_Secondary() throws SQLException {

  }


  public String getPassword() {

    return null;
  }


  public String getDescription() {

    return null;
  }


  public String getIfxCLIENT_LOCALE() {

    return null;
  }


  public void setIfxDBSPACETEMP(String temp) {

  }


  public String getIfxDB_LOCALE() {

    return null;
  }


  public void setDataSourceName(String dsName) {

  }


  public String getIfxAPPENDISAM() {

    return null;
  }


  public void setIfxAPPENDISAM(String x) {

  }


  public void addProp(String x, Object y) {

  }


  public Object getProp(String x) {
    return this.datasource.getProp(x);
  }


  public void readProperties(InputStream x) throws IOException {
    this.datasource.readProperties(x);
  }


  public String getDatabaseName() {
    return this.datasource.getDatabaseName();
  }


  public void setDatabaseName(String x) {
    this.datasource.setDatabaseName(x);
  }


  public void setDescription(String x) {

  }


  public void setPassword(String x) {

  }


  public int getPortNumber() {

    return -1;
  }


  public void setPortNumber(int x) {

  }


  public String getRoleName() {

    return null;
  }


  public void setRoleName(String x) {

  }


  public String getServerName() {

    return null;
  }


  public void setServerName(String x) {

  }


  public String getIfxTRUSTED_CONTEXT() {

    return null;
  }


  public void setIfxTRUSTED_CONTEXT(String x) {

  }


  public void setIfxDirectConnection() {

  }


  public void setUser(String x) {

  }


  public void setIfxPORTNO_SECONDARY(int x) {

  }


  public int getIfxPORTNO_SECONDARY() {

    return -1;
  }


  public void setIfxIFXHOST_SECONDARY(String x) {

  }


  public String getIfxIFXHOST_SECONDARY() {

    return null;
  }


  public void setIfxINFORMIXSERVER_SECONDARY(String x) {

  }


  public String getIfxINFORMIXSERVER_SECONDARY() {

    return null;
  }


  public void setIfxENABLE_HDRSWITCH(boolean x) {

  }


  public boolean getIfxENABLE_HDRSWITCH() {

    return false;
  }


  public String getIfxIFXHOST() {
    return this.datasource.getIfxIFXHOST();
  }


  public void setIfxIFXHOST(String x) {
    this.datasource.setIfxIFXHOST(x);
  }


  public String getIfxJDBCTEMP() {

    return null;
  }


  public void setIfxJDBCTEMP(String x) {

  }


  public String getIfxSECURITY() {

    return null;
  }


  public String getIfxCSM() {

    return null;
  }


  public void setIfxSECURITY(String x) {

  }


  public void setIfxCSM(String x) {

  }


  public String getIfxPROXY() {

    return null;
  }


  public void setIfxPROXY(String x) {

  }


  public boolean isIfxENABLE_TYPE_CACHE() {
    return false;
  }


  public void setIfxENABLE_TYPE_CACHE(boolean x) {

  }


  public String getIfxSQLH_TYPE() {

    return null;
  }


  public void setIfxSQLH_TYPE(String x) {

  }


  public String getIfxSSLCONNECTION() {

    return null;
  }


  public void setIfxSSLCONNECTION(String x) {

  }


  public String getIfxSQLH_FILE() {

    return null;
  }


  public void setIfxSQLH_FILE(String x) {

  }


  public String getIfxLDAP_URL() {

    return null;
  }


  public void setIfxLDAP_URL(String x) {

  }


  public String getIfxLDAP_IFXBASE() {

    return null;
  }


  public void setIfxLDAP_IFXBASE(String x) {

  }


  public String getIfxLDAP_USER() {

    return null;
  }


  public void setIfxLDAP_USER(String x) {

  }


  public String getIfxLDAP_PASSWD() {

    return null;
  }


  public void setIfxLDAP_PASSWD(String x) {

  }


  public String getIfxSQLH_LOC() {

    return null;
  }


  public void setIfxSQLH_LOC(String x) {

  }


  public int getIfxFET_BUF_SIZE() {

    return -1;
  }


  public void setIfxFET_BUF_SIZE(int x) {

  }


  public int getIfxBIG_FET_BUF_SIZE() {

    return -1;
  }


  public void setIfxBIG_FET_BUF_SIZE(int x) {

  }


  public boolean

  isIfxUSEV5SERVER() {
    return false;
  }


  public void setIfxUSEV5SERVER(boolean x) {

  }


  public int getIfxLOBCACHE() {

    return -1;
  }


  public void setIfxLOBCACHE(int x) {

  }


  public boolean

  isIfxIFX_USEPUT() {
    return false;
  }


  public void setIfxIFX_USEPUT(boolean x) {

  }


  public boolean

  isIfxIFX_AUTOFREE() {
    return false;
  }


  public void setIfxIFX_AUTOFREE(boolean x) {

  }


  public boolean

  isIfxDELIMIDENT() {
    return false;
  }


  public void setIfxDELIMIDENT(boolean x) {

  }


  public int getIfxINFORMIXSTACKSIZE() {

    return -1;
  }


  public void setIfxINFORMIXSTACKSIZE(int x) {

  }


  public String getIfxDBSPACETEMP() {

    return null;
  }


  public void setIfxDB_LOCALE(String x) {

  }


  public void setIfxCLIENT_LOCALE(String x) {

  }


  public String getUser() {

    return null;
  }


  public Properties getDsProperties() {
    return this.datasource.getDsProperties();
  }


  public String getDataSourceName() {

    return null;
  }


  public void writeProperties(OutputStream x)

    throws IOException {

  }


  public String getIfxNEWLOCALE() {

    return null;
  }


  public String getIfxNEWNLSMAP() {

    return null;
  }


  public void setIfxNEWLOCALE(String x) {

  }


  public void setIfxNEWNLSMAP(String x) {

  }


  public String getIfxNEWCODESET() {

    return null;
  }


  public void setIfxNEWCODESET(String x) {

  }


  public String getIfxDBDATE() {

    return null;
  }


  public void setIfxDBDATE(String x) {

  }


  public String getIfxGL_DATE() {

    return null;
  }


  public void setIfxGL_DATE(String x) {

  }


  public String getIfxDBTIME() {

    return null;
  }


  public void setIfxDBTIME(String x) {

  }


  public String getIfxGL_DATETIME() {

    return null;
  }


  public void setIfxGL_DATETIME(String x) {

  }


  public boolean isIfxUSE_DTENV() {
    return false;
  }


  public void setIfxUSE_DTENV(boolean x) {

  }


  public String getIfxDBCENTURY() {

    return null;
  }


  public void setIfxDBCENTURY(String x) {

  }


  public String getIfxSTMT_CACHE() {

    return null;
  }


  public void setIfxSTMT_CACHE(String x) {

  }


  public String getIfxNODEFDAC() {

    return null;
  }


  public void setIfxNODEFDAC(String x) {

  }


  public String getIfxDBTEMP() {

    return null;
  }


  public void setIfxDBTEMP(String x) {

  }


  public String getIfxPSORT_DBTEMP() {

    return null;
  }


  public void setIfxPSORT_DBTEMP(String x) {

  }


  public String getIfxPSORT_NPROCS() {

    return null;
  }


  public void setIfxPSORT_NPROCS(String x) {

  }


  public String getIfxDBUPSPACE() {

    return null;
  }


  public void setIfxDBUPSPACE(String x) {

  }


  public String getIfxPDQPRIORITY() {

    return null;
  }


  public void setIfxPDQPRIORITY(String x) {

  }


  public String getIfxIFX_DIRECTIVES() {

    return null;
  }


  public void setIfxIFX_DIRECTIVES(String x) {

  }


  public String getIfxIFX_EXTDIRECTIVES() {

    return null;
  }


  public void setIfxIFX_EXTDIRECTIVES(String x) {

  }


  public String getIfxOPTCOMPIND() {

    return null;
  }


  public void setIfxOPTCOMPIND(String x) {

  }


  public int getIfxINFORMIXCONRETRY() {

    return -1;
  }


  public void setIfxINFORMIXCONRETRY(int x) {

  }


  public int getIfxINFORMIXCONTIME() {

    return -1;
  }


  public void setIfxINFORMIXCONTIME(int x) {

  }


  public String getIfxINFORMIXOPCACHE() {

    return null;
  }


  public void setIfxINFORMIXOPCACHE(String x) {

  }


  public String getIfxPLCONFIG() {

    return null;
  }


  public void setIfxPLCONFIG(String x) {

  }


  public String getIfxPATH() {

    return null;
  }


  public void setIfxPATH(String x) {

  }


  public String getIfxPLOAD_LO_PATH() {

    return null;
  }


  public void setIfxPLOAD_LO_PATH(String x) {

  }


  public String getIfxOPT_GOAL() {

    return null;
  }


  public void setIfxOPT_GOAL(String x) {

  }


  public String getIfxOPTOFC() {

    return null;
  }


  public void setIfxOPTOFC(String x) {

  }


  public boolean isIfxOPTOFC() {
    return false;
  }


  public boolean isIfxDBANSIWARN() {
    return false;
  }


  public void setIfxDBANSIWARN(boolean x) {

  }


  public void setIfxIFX_GET_SMFLOAT_AS_FLOAT(int x) {

  }


  public int getIfxIFX_GET_SMFLOAT_AS_FLOAT() {

    return -1;
  }


  public void setIfxIFX_SET_FLOAT_AS_SMFLOAT(int x) {

  }


  public int getIfxIFX_SET_FLOAT_AS_SMFLOAT() {

    return -1;
  }


  public void setIfxIFX_CODESETLOB(int x) {

  }


  public int getIfxIFX_CODESETLOB() {

    return -1;
  }


  public void setIfxIFX_BATCHUPDATE_PER_SPEC(int x) {

  }


  public int getIfxIFX_BATCHUPDATE_PER_SPEC() {

    return -1;
  }


  public void setIfxIFX_LOCK_MODE_WAIT(int x) {

  }


  public int getIfxIFX_LOCK_MODE_WAIT() {

    return -1;
  }


  public void setIfxIFX_ISOLATION_LEVEL(String x) {
    this.datasource.setIfxIFX_ISOLATION_LEVEL(x);
  }


  public String getIfxIFX_ISOLATION_LEVEL() {

    return null;
  }


  public void setIfxIFX_USE_STRENC(boolean x) {

  }


  public boolean getIfxIFX_USE_STRENC() {

    return false;
  }


  public void setIfxIFX_SOC_TIMEOUT(int x) {

  }


  public int getIfxIFX_SOC_TIMEOUT() {

    return -1;
  }


  public void setIfxIFX_SOC_KEEPALIVE(boolean x) {

  }


  public boolean getIfxIFX_SOC_KEEPALIVE() {

    return false;
  }


  public void setIfxIFX_PAD_VARCHAR(String x) {

  }


  public String getIfxIFX_PAD_VARCHAR() {

    return null;
  }


  public int getIfxTRACE() {

    return -1;
  }


  public void setIfxTRACE(int x) {

  }


  public int getIfxPROTOCOLTRACE() {

    return -1;
  }


  public void setIfxPROTOCOLTRACE(int x) {

  }


  public String getIfxTRACEFILE() {

    return null;
  }


  public void setIfxTRACEFILE(String x) {

  }


  public String getIfxPROTOCOLTRACEFILE() {

    return null;
  }


  public void setIfxPROTOCOLTRACEFILE(String x) {

  }


  public String getIfxSQLIDEBUG() {

    return null;
  }


  public void setIfxSQLIDEBUG(String x) {

  }


  public void setIfxALLOWREGISTEROUTFORINPARAM(String x) {

  }


  public String getIfxALLOWREGISTEROUTFORINPARAM() {

    return null;
  }


  public int getIfxIFX_TRIMTRAILINGSPACES() {

    return -1;
  }


  public void setIfxIFX_TRIMTRAILINGSPACES(int x) {

  }


  public int getIfxIFX_FLAT_UCSQ() {

    return -1;
  }


  public void setIfxIFX_FLAT_UCSQ(int x) {

  }


  public void removeProperty(String x) {

  }
}
