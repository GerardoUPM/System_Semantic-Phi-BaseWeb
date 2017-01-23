package edu.upm.spbw.persistence.bo;

import edu.upm.spbw.utils.ApplicationMessages;
import edu.upm.spbw.utils.Constants;
import edu.upm.spbw.utils.DateUtils;

// Generated 28-feb-2016 11:50:28 by Hibernate Tools 3.4.0.CR1

/**
 * Usdbloqu generated by hbm2java
 */
public class Usdbloqu implements java.io.Serializable, AbstractBO<UsdbloquId> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsdbloquId id;
	private int bluilognf;
	private long blutdesnf;
	private String usuemadaf;
	private String bludautsf;
	/* Fecha del bloqueo */
	private String usutbloff;
	/* Fecha desbloqueo */
	private String blutdesff;
	/* Booleano */
	private boolean bbludautsf;

	public Usdbloqu() {
	}

	public Usdbloqu(UsdbloquId id, int bluilognf, long blutdesnf,
			String usuemadaf, String bludautsf) {
		this.id = id;
		this.bluilognf = bluilognf;
		this.blutdesnf = blutdesnf;
		this.usuemadaf = usuemadaf;
		this.bludautsf = bludautsf;
	}

	public UsdbloquId getId() {
		return this.id;
	}

	public void setId(UsdbloquId id) {
		this.id = id;
	}

	public int getBluilognf() {
		return this.bluilognf;
	}

	public void setBluilognf(int bluilognf) {
		this.bluilognf = bluilognf;
	}

	public long getBlutdesnf() {
		return this.blutdesnf;
	}

	public void setBlutdesnf(long blutdesnf) {
		this.blutdesnf = blutdesnf;
	}

	public String getUsuemadaf() {
		return this.usuemadaf;
	}

	public void setUsuemadaf(String usuemadaf) {
		this.usuemadaf = usuemadaf;
	}

	public String getBludautsf() {
		return this.bludautsf;
	}

	public void setBludautsf(String bludautsf) {
		this.bludautsf = bludautsf;
	}

	@Override
	public UsdbloquId getPrimaryKey() {
		return id;
	}

	@Override
	public void prepareObject() {
		// Booleano
		this.bbludautsf = Constants.ONE.equals(this.bludautsf);
		// Asigna String de fecha
		this.usutbloff = DateUtils.convertTime(this.id.getUsutblonf());
		// Revisa si ya se hizo el desbloqueo
		if (this.blutdesnf != 0) {/* Desbloqueo realizado */
			// String de desbloqueo
			this.blutdesff = DateUtils.convertTime(this.blutdesnf);
			// Revisa si fue automatico
			if (this.bbludautsf) {
				// Automatico
				this.usuemadaf = ApplicationMessages.getMessage("USR0029");
			}
		} else {
			// Sin desbloqueo
			this.usuemadaf = ApplicationMessages.getMessage("USR0030");
			this.blutdesff = ApplicationMessages.getMessage("USR0031");
		}
	}

	@Override
	public void prepareToUpdate() {

	}

	/**
	 * @return the bbludautsf
	 */
	public boolean isBbludautsf() {
		return bbludautsf;
	}

	/**
	 * @param bbludautsf
	 *            the bbludautsf to set
	 */
	public void setBbludautsf(boolean bbludautsf) {
		this.bbludautsf = bbludautsf;
	}

	/**
	 * @return the blutdesff
	 */
	public String getBlutdesff() {
		return blutdesff;
	}

	/**
	 * @param blutdesff
	 *            the blutdesff to set
	 */
	public void setBlutdesff(String blutdesff) {
		this.blutdesff = blutdesff;
	}

	/**
	 * @param usutbloff
	 *            the usutbloff to set
	 */
	public void setUsutbloff(String usutbloff) {
		this.usutbloff = usutbloff;
	}

	/**
	 * @return the usutbloff
	 */
	public String getUsutbloff() {
		return usutbloff;
	}
}
