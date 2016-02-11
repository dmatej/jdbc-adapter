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

/** * @author David Matějček */
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
    return this.datasource.getCPMFreeCount();
  }


  public IfxConnectionPoolDataSource getCPDS() {
    return this.datasource.getCPDS();
  }


  public void activateHDRPool_Primary() throws SQLException {
    this.datasource.activateHDRPool_Primary();
  }


  public void activateHDRPool_Secondary() throws SQLException {
    this.datasource.activateHDRPool_Secondary();
  }


  public String getPassword() {
    return this.datasource.getPassword();
  }


  public String getDescription() {
    return this.datasource.getDescription();
  }


  public String getIfxCLIENT_LOCALE() {
    return this.datasource.getIfxCLIENT_LOCALE();
  }


  public void setIfxDBSPACETEMP(final String temp) {
    this.datasource.setIfxDBSPACETEMP(temp);
  }


  public String getIfxDB_LOCALE() {
    return this.datasource.getIfxDB_LOCALE();
  }


  public void setDataSourceName(final String dsName) {
    this.datasource.setDataSourceName(dsName);
  }


  public String getIfxAPPENDISAM() {
    return this.datasource.getIfxAPPENDISAM();
  }


  public void setIfxAPPENDISAM(final String x) {
    this.datasource.setIfxAPPENDISAM(x);
  }


  public void addProp(final String x, final Object y) {
    this.datasource.addProp(x, y);
  }


  public Object getProp(final String x) {
    return this.datasource.getProp(x);
  }


  public void readProperties(final InputStream x) throws IOException {
    this.datasource.readProperties(x);
  }


  public String getDatabaseName() {
    return this.datasource.getDatabaseName();
  }


  public void setDatabaseName(final String x) {
    this.datasource.setDatabaseName(x);
  }


  public void setDescription(final String x) {
    this.datasource.setDescription(x);
  }


  public void setPassword(final String x) {
    this.datasource.setPassword(x);
  }


  public int getPortNumber() {
    return this.datasource.getPortNumber();
  }


  public void setPortNumber(final int x) {
    this.datasource.setPortNumber(x);
  }


  public String getRoleName() {
    return this.datasource.getRoleName();
  }


  public void setRoleName(final String x) {
    this.datasource.setRoleName(x);
  }


  public String getServerName() {
    return this.datasource.getServerName();
  }


  public void setServerName(final String x) {
    this.datasource.setServerName(x);
  }


  public String getIfxTRUSTED_CONTEXT() {
    return this.datasource.getIfxTRUSTED_CONTEXT();
  }


  public void setIfxTRUSTED_CONTEXT(final String x) {
    this.datasource.setIfxTRUSTED_CONTEXT(x);
  }


  public void setIfxDirectConnection() {
    this.datasource.setIfxDirectConnection();
  }


  public void setUser(final String x) {
    this.datasource.setUser(x);
  }


  public void setIfxPORTNO_SECONDARY(final int x) {
    this.datasource.setIfxPORTNO_SECONDARY(x);
  }


  public int getIfxPORTNO_SECONDARY() {
    return this.datasource.getIfxPORTNO_SECONDARY();
  }


  public void setIfxIFXHOST_SECONDARY(final String x) {
    this.datasource.setIfxIFXHOST_SECONDARY(x);
  }


  public String getIfxIFXHOST_SECONDARY() {
    return this.datasource.getIfxIFXHOST_SECONDARY();
  }


  public void setIfxINFORMIXSERVER_SECONDARY(final String x) {
    this.datasource.setIfxINFORMIXSERVER_SECONDARY(x);
  }


  public String getIfxINFORMIXSERVER_SECONDARY() {
    return this.datasource.getIfxINFORMIXSERVER_SECONDARY();
  }


  public void setIfxENABLE_HDRSWITCH(final boolean x) {
    this.datasource.setIfxENABLE_HDRSWITCH(x);
  }


  public boolean getIfxENABLE_HDRSWITCH() {
    return this.datasource.getIfxENABLE_HDRSWITCH();
  }


  public String getIfxIFXHOST() {
    return this.datasource.getIfxIFXHOST();
  }


  public void setIfxIFXHOST(final String x) {
    this.datasource.setIfxIFXHOST(x);
  }


  public String getIfxJDBCTEMP() {
    return this.datasource.getIfxJDBCTEMP();
  }


  public void setIfxJDBCTEMP(final String x) {
    this.datasource.setIfxJDBCTEMP(x);
  }


  public String getIfxSECURITY() {
    return this.datasource.getIfxSECURITY();
  }


  public String getIfxCSM() {
    return this.datasource.getIfxCSM();
  }


  public void setIfxSECURITY(final String x) {
    this.datasource.setIfxSECURITY(x);
  }


  public void setIfxCSM(final String x) {
    this.datasource.setIfxCSM(x);
  }


  public String getIfxPROXY() {
    return this.datasource.getIfxPROXY();
  }


  public void setIfxPROXY(final String x) {
    this.datasource.setIfxPROXY(x);
  }


  public boolean isIfxENABLE_TYPE_CACHE() {
    return this.datasource.isIfxENABLE_TYPE_CACHE();
  }


  public void setIfxENABLE_TYPE_CACHE(final boolean x) {
    this.datasource.setIfxENABLE_TYPE_CACHE(x);
  }


  public String getIfxSQLH_TYPE() {
    return this.datasource.getIfxSQLH_TYPE();
  }


  public void setIfxSQLH_TYPE(final String x) {
    this.datasource.setIfxSQLH_TYPE(x);
  }


  public String getIfxSSLCONNECTION() {
    return this.datasource.getIfxSSLCONNECTION();
  }


  public void setIfxSSLCONNECTION(final String x) {
    this.datasource.setIfxSSLCONNECTION(x);
  }


  public String getIfxSQLH_FILE() {
    return this.datasource.getIfxSQLH_FILE();
  }


  public void setIfxSQLH_FILE(final String x) {
    this.datasource.setIfxSQLH_FILE(x);
  }


  public String getIfxLDAP_URL() {
    return this.datasource.getIfxLDAP_URL();
  }


  public void setIfxLDAP_URL(final String x) {
    this.datasource.setIfxLDAP_URL(x);
  }


  public String getIfxLDAP_IFXBASE() {
    return this.datasource.getIfxLDAP_IFXBASE();
  }


  public void setIfxLDAP_IFXBASE(final String x) {
    this.datasource.setIfxLDAP_IFXBASE(x);
  }


  public String getIfxLDAP_USER() {
    return this.datasource.getIfxLDAP_USER();
  }


  public void setIfxLDAP_USER(final String x) {
    this.datasource.setIfxLDAP_USER(x);
  }


  public String getIfxLDAP_PASSWD() {
    return this.datasource.getIfxLDAP_PASSWD();
  }


  public void setIfxLDAP_PASSWD(final String x) {
    this.datasource.setIfxLDAP_PASSWD(x);
  }


  public String getIfxSQLH_LOC() {
    return this.datasource.getIfxSQLH_LOC();
  }


  public void setIfxSQLH_LOC(final String x) {
    this.datasource.setIfxSQLH_LOC(x);
  }


  public int getIfxFET_BUF_SIZE() {
    return this.datasource.getIfxFET_BUF_SIZE();
  }


  public void setIfxFET_BUF_SIZE(final int x) {
    this.datasource.setIfxFET_BUF_SIZE(x);
  }


  public int getIfxBIG_FET_BUF_SIZE() {
    return this.datasource.getIfxBIG_FET_BUF_SIZE();
  }


  public void setIfxBIG_FET_BUF_SIZE(final int x) {
    this.datasource.setIfxBIG_FET_BUF_SIZE(x);
  }


  public boolean isIfxUSEV5SERVER() {
    return this.datasource.isIfxUSEV5SERVER();
  }


  public void setIfxUSEV5SERVER(final boolean x) {
    this.datasource.setIfxUSEV5SERVER(x);
  }


  public int getIfxLOBCACHE() {
    return this.datasource.getIfxLOBCACHE();
  }


  public void setIfxLOBCACHE(final int x) {
    this.datasource.setIfxLOBCACHE(x);
  }


  public boolean isIfxIFX_USEPUT() {
    return this.datasource.isIfxIFX_USEPUT();
  }


  public void setIfxIFX_USEPUT(final boolean x) {
    this.datasource.setIfxIFX_USEPUT(x);
  }


  public boolean isIfxIFX_AUTOFREE() {
    return this.datasource.isIfxIFX_AUTOFREE();
  }


  public void setIfxIFX_AUTOFREE(final boolean x) {
    this.datasource.setIfxIFX_AUTOFREE(x);
  }


  public boolean isIfxDELIMIDENT() {
    return this.datasource.isIfxDELIMIDENT();
  }


  public void setIfxDELIMIDENT(final boolean x) {
    this.datasource.setIfxDELIMIDENT(x);
  }


  public int getIfxINFORMIXSTACKSIZE() {
    return this.datasource.getIfxINFORMIXSTACKSIZE();
  }


  public void setIfxINFORMIXSTACKSIZE(final int x) {
    this.datasource.setIfxINFORMIXSTACKSIZE(x);
  }


  public String getIfxDBSPACETEMP() {
    return this.datasource.getIfxDBSPACETEMP();
  }


  public void setIfxDB_LOCALE(final String x) {
    this.datasource.setIfxDB_LOCALE(x);
  }


  public void setIfxCLIENT_LOCALE(final String x) {
    this.datasource.setIfxCLIENT_LOCALE(x);
  }


  public String getUser() {
    return this.datasource.getUser();
  }


  public Properties getDsProperties() {
    return this.datasource.getDsProperties();
  }


  public String getDataSourceName() {
    return this.datasource.getDataSourceName();
  }


  public void writeProperties(final OutputStream x) throws IOException {
    this.datasource.writeProperties(x);
  }


  public String getIfxNEWLOCALE() {
    return this.datasource.getIfxNEWLOCALE();
  }


  public String getIfxNEWNLSMAP() {
    return this.datasource.getIfxNEWNLSMAP();
  }


  public void setIfxNEWLOCALE(final String x) {
    this.datasource.setIfxNEWLOCALE(x);
  }


  public void setIfxNEWNLSMAP(final String x) {
    this.datasource.setIfxNEWNLSMAP(x);
  }


  public String getIfxNEWCODESET() {
    return this.datasource.getIfxNEWCODESET();
  }


  public void setIfxNEWCODESET(final String x) {
    this.datasource.setIfxNEWCODESET(x);
  }


  public String getIfxDBDATE() {
    return this.datasource.getIfxDBDATE();
  }


  public void setIfxDBDATE(final String x) {
    this.datasource.setIfxDBDATE(x);
  }


  public String getIfxGL_DATE() {
    return this.datasource.getIfxGL_DATE();
  }


  public void setIfxGL_DATE(final String x) {
    this.datasource.setIfxGL_DATE(x);
  }


  public String getIfxDBTIME() {
    return this.datasource.getIfxDBTIME();
  }


  public void setIfxDBTIME(final String x) {
    this.datasource.setIfxDBTIME(x);
  }


  public String getIfxGL_DATETIME() {
    return this.datasource.getIfxGL_DATETIME();
  }


  public void setIfxGL_DATETIME(final String x) {
    this.datasource.setIfxGL_DATETIME(x);
  }


  public boolean isIfxUSE_DTENV() {
    return this.datasource.isIfxUSE_DTENV();
  }


  public void setIfxUSE_DTENV(final boolean x) {
    this.datasource.setIfxUSE_DTENV(x);
  }


  public String getIfxDBCENTURY() {
    return this.datasource.getIfxDBCENTURY();
  }


  public void setIfxDBCENTURY(final String x) {
    this.datasource.setIfxDBCENTURY(x);
  }


  public String getIfxSTMT_CACHE() {
    return this.datasource.getIfxSTMT_CACHE();
  }


  public void setIfxSTMT_CACHE(final String x) {
    this.datasource.setIfxSTMT_CACHE(x);
  }


  public String getIfxNODEFDAC() {
    return this.datasource.getIfxNODEFDAC();
  }


  public void setIfxNODEFDAC(final String x) {
    this.datasource.setIfxNODEFDAC(x);
  }


  public String getIfxDBTEMP() {
    return this.datasource.getIfxDBTEMP();
  }


  public void setIfxDBTEMP(final String x) {
    this.datasource.setIfxDBTEMP(x);
  }


  public String getIfxPSORT_DBTEMP() {
    return this.datasource.getIfxPSORT_DBTEMP();
  }


  public void setIfxPSORT_DBTEMP(final String x) {
    this.datasource.setIfxPSORT_DBTEMP(x);
  }


  public String getIfxPSORT_NPROCS() {
    return this.datasource.getIfxPSORT_NPROCS();
  }


  public void setIfxPSORT_NPROCS(final String x) {
    this.datasource.setIfxPSORT_NPROCS(x);
  }


  public String getIfxDBUPSPACE() {
    return this.datasource.getIfxDBUPSPACE();
  }


  public void setIfxDBUPSPACE(final String x) {
    this.datasource.setIfxDBUPSPACE(x);
  }


  public String getIfxPDQPRIORITY() {
    return this.datasource.getIfxPDQPRIORITY();
  }


  public void setIfxPDQPRIORITY(final String x) {
    this.datasource.setIfxPDQPRIORITY(x);
  }


  public String getIfxIFX_DIRECTIVES() {
    return this.datasource.getIfxIFX_DIRECTIVES();
  }


  public void setIfxIFX_DIRECTIVES(final String x) {
    this.datasource.setIfxIFX_DIRECTIVES(x);
  }


  public String getIfxIFX_EXTDIRECTIVES() {
    return this.datasource.getIfxIFX_EXTDIRECTIVES();
  }


  public void setIfxIFX_EXTDIRECTIVES(final String x) {
    this.datasource.setIfxIFX_EXTDIRECTIVES(x);
  }


  public String getIfxOPTCOMPIND() {
    return this.datasource.getIfxOPTCOMPIND();
  }


  public void setIfxOPTCOMPIND(final String x) {
    this.datasource.setIfxOPTCOMPIND(x);
  }


  public int getIfxINFORMIXCONRETRY() {
    return this.datasource.getIfxINFORMIXCONRETRY();
  }


  public void setIfxINFORMIXCONRETRY(final int x) {
    this.datasource.setIfxINFORMIXCONRETRY(x);
  }


  public int getIfxINFORMIXCONTIME() {
    return this.datasource.getIfxINFORMIXCONTIME();
  }


  public void setIfxINFORMIXCONTIME(final int x) {
    this.datasource.setIfxINFORMIXCONTIME(x);
  }


  public String getIfxINFORMIXOPCACHE() {
    return this.datasource.getIfxINFORMIXOPCACHE();
  }


  public void setIfxINFORMIXOPCACHE(final String x) {
    this.datasource.setIfxINFORMIXOPCACHE(x);
  }


  public String getIfxPLCONFIG() {
    return this.datasource.getIfxPLCONFIG();
  }


  public void setIfxPLCONFIG(final String x) {
    this.datasource.setIfxPLCONFIG(x);
  }


  public String getIfxPATH() {
    return this.datasource.getIfxPATH();
  }


  public void setIfxPATH(final String x) {
    this.datasource.setIfxPATH(x);
  }


  public String getIfxPLOAD_LO_PATH() {
    return this.datasource.getIfxPLOAD_LO_PATH();
  }


  public void setIfxPLOAD_LO_PATH(final String x) {
    this.datasource.setIfxPLOAD_LO_PATH(x);
  }


  public String getIfxOPT_GOAL() {
    return this.datasource.getIfxOPT_GOAL();
  }


  public void setIfxOPT_GOAL(final String x) {
    this.datasource.setIfxOPT_GOAL(x);
  }


  public String getIfxOPTOFC() {
    return this.datasource.getIfxOPTOFC();
  }


  public void setIfxOPTOFC(final String x) {
    this.datasource.setIfxOPTOFC(x);
  }


  public boolean isIfxOPTOFC() {
    return this.datasource.isIfxOPTOFC();
  }


  public boolean isIfxDBANSIWARN() {
    return this.datasource.isIfxDBANSIWARN();
  }


  public void setIfxDBANSIWARN(final boolean x) {
    this.datasource.setIfxDBANSIWARN(x);
  }


  public void setIfxIFX_GET_SMFLOAT_AS_FLOAT(final int x) {
    this.datasource.setIfxIFX_GET_SMFLOAT_AS_FLOAT(x);
  }


  public int getIfxIFX_GET_SMFLOAT_AS_FLOAT() {
    return this.datasource.getIfxIFX_GET_SMFLOAT_AS_FLOAT();
  }


  public void setIfxIFX_SET_FLOAT_AS_SMFLOAT(final int x) {
    this.datasource.setIfxIFX_SET_FLOAT_AS_SMFLOAT(x);
  }


  public int getIfxIFX_SET_FLOAT_AS_SMFLOAT() {
    return this.datasource.getIfxIFX_SET_FLOAT_AS_SMFLOAT();
  }


  public void setIfxIFX_CODESETLOB(final int x) {
    this.datasource.setIfxIFX_CODESETLOB(x);
  }


  public int getIfxIFX_CODESETLOB() {
    return this.datasource.getIfxIFX_CODESETLOB();
  }


  public void setIfxIFX_BATCHUPDATE_PER_SPEC(final int x) {
    this.datasource.setIfxIFX_BATCHUPDATE_PER_SPEC(x);
  }


  public int getIfxIFX_BATCHUPDATE_PER_SPEC() {
    return this.datasource.getIfxIFX_BATCHUPDATE_PER_SPEC();
  }


  public void setIfxIFX_LOCK_MODE_WAIT(final int x) {
    this.datasource.setIfxIFX_LOCK_MODE_WAIT(x);
  }


  public int getIfxIFX_LOCK_MODE_WAIT() {
    return this.datasource.getIfxIFX_LOCK_MODE_WAIT();
  }


  public void setIfxIFX_ISOLATION_LEVEL(final String x) {
    this.datasource.setIfxIFX_ISOLATION_LEVEL(x);
  }


  public String getIfxIFX_ISOLATION_LEVEL() {
    return this.datasource.getIfxIFX_ISOLATION_LEVEL();
  }


  public void setIfxIFX_USE_STRENC(final boolean x) {
    this.datasource.setIfxIFX_USE_STRENC(x);
  }


  public boolean getIfxIFX_USE_STRENC() {
    return this.datasource.getIfxIFX_USE_STRENC();
  }


  public void setIfxIFX_SOC_TIMEOUT(final int x) {
    this.datasource.setIfxIFX_SOC_TIMEOUT(x);
  }


  public int getIfxIFX_SOC_TIMEOUT() {
    return this.datasource.getIfxIFX_SOC_TIMEOUT();
  }


  public void setIfxIFX_SOC_KEEPALIVE(final boolean x) {
    this.datasource.setIfxIFX_SOC_KEEPALIVE(x);
  }


  public boolean getIfxIFX_SOC_KEEPALIVE() {
    return this.datasource.getIfxIFX_SOC_KEEPALIVE();
  }


  public void setIfxIFX_PAD_VARCHAR(final String x) {
    this.datasource.setIfxIFX_PAD_VARCHAR(x);
  }


  public String getIfxIFX_PAD_VARCHAR() {
    return this.datasource.getIfxIFX_PAD_VARCHAR();
  }


  public int getIfxTRACE() {
    return this.datasource.getIfxTRACE();
  }


  public void setIfxTRACE(final int x) {
    this.datasource.setIfxTRACE(x);
  }


  public int getIfxPROTOCOLTRACE() {
    return this.datasource.getIfxPROTOCOLTRACE();
  }


  public void setIfxPROTOCOLTRACE(final int x) {
    this.datasource.setIfxPROTOCOLTRACE(x);
  }


  public String getIfxTRACEFILE() {
    return this.datasource.getIfxTRACEFILE();
  }


  public void setIfxTRACEFILE(final String x) {
    this.datasource.setIfxTRACEFILE(x);
  }


  public String getIfxPROTOCOLTRACEFILE() {
    return this.datasource.getIfxPROTOCOLTRACEFILE();
  }


  public void setIfxPROTOCOLTRACEFILE(final String x) {
    this.datasource.setIfxPROTOCOLTRACEFILE(x);
  }


  public String getIfxSQLIDEBUG() {
    return this.datasource.getIfxSQLIDEBUG();
  }


  public void setIfxSQLIDEBUG(final String x) {
    this.datasource.setIfxSQLIDEBUG(x);
  }


  public void setIfxALLOWREGISTEROUTFORINPARAM(final String x) {
    this.datasource.setIfxALLOWREGISTEROUTFORINPARAM(x);
  }


  public String getIfxALLOWREGISTEROUTFORINPARAM() {
    return this.datasource.getIfxALLOWREGISTEROUTFORINPARAM();
  }


  public int getIfxIFX_TRIMTRAILINGSPACES() {
    return this.datasource.getIfxIFX_TRIMTRAILINGSPACES();
  }


  public void setIfxIFX_TRIMTRAILINGSPACES(final int x) {
    this.datasource.setIfxIFX_TRIMTRAILINGSPACES(x);
  }


  public int getIfxIFX_FLAT_UCSQ() {
    return this.datasource.getIfxIFX_FLAT_UCSQ();
  }


  public void setIfxIFX_FLAT_UCSQ(final int x) {
    this.datasource.setIfxIFX_FLAT_UCSQ(x);
  }


  public void removeProperty(final String x) {
    this.datasource.removeProperty(x);
  }
}
