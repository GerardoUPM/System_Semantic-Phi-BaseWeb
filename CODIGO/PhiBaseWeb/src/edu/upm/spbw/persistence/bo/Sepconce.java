package edu.upm.spbw.persistence.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;

import edu.upm.spbw.persistence.dao.ISepconceDAO;
import edu.upm.spbw.persistence.dao.ISeprelcoDAO;
import edu.upm.spbw.utils.Constants;
import edu.upm.spbw.utils.LogLogger;
import edu.upm.spbw.utils.SpringAppContext;

// Generated 28-feb-2016 11:40:56 by Hibernate Tools 3.4.0.CR1

/**
 * Sepconce generated by hbm2java
 */
public class Sepconce implements java.io.Serializable, AbstractBO<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cosccosak;
	private String cosdcosaf;
	private String cosrdftaf;
	private int cosnrelnf;
	private String cosccopak;
	private String cosdocuaf;
	// Lista de relaciones
	private List<Seprelco> relcos;
	/* Descripcion concepto padre */
	private String cosdcopaf;

	public Sepconce() {
	}

	public Sepconce(String cosccosak, String cosdcosaf, String cosrdftaf,
			int cosnrelnf, String cosccopak) {
		this.cosccosak = cosccosak;
		this.cosdcosaf = cosdcosaf;
		this.cosrdftaf = cosrdftaf;
		this.cosnrelnf = cosnrelnf;
		this.cosccopak = cosccopak;
	}

	public String getCosccosak() {
		return this.cosccosak;
	}

	public void setCosccosak(String cosccosak) {
		this.cosccosak = cosccosak;
	}

	public String getCosdcosaf() {
		return this.cosdcosaf;
	}

	public void setCosdcosaf(String cosdcosaf) {
		this.cosdcosaf = cosdcosaf;
	}

	public String getCosrdftaf() {
		return this.cosrdftaf;
	}

	public void setCosrdftaf(String cosrdftaf) {
		this.cosrdftaf = cosrdftaf;
	}

	public int getCosnrelnf() {
		return this.cosnrelnf;
	}

	public void setCosnrelnf(int cosnrelnf) {
		this.cosnrelnf = cosnrelnf;
	}

	public String getCosccopak() {
		return this.cosccopak;
	}

	public void setCosccopak(String cosccopak) {
		this.cosccopak = cosccopak;
	}

	@Override
	public String getPrimaryKey() {
		return cosccosak;
	}

	@Override
	public void prepareObject() {
		// Prepara campos
		if (this.cosccosak != null)
			this.cosccosak = this.cosccosak.trim();
		else
			this.cosccosak = Constants.BLANKS;
		if (this.cosdcosaf != null)
			this.cosdcosaf = this.cosdcosaf.trim();
		else
			this.cosdcosaf = Constants.BLANKS;
		if (this.cosrdftaf != null)
			this.cosrdftaf = this.cosrdftaf.trim();
		else
			this.cosrdftaf = Constants.BLANKS;
		if (this.cosccopak != null)
			this.cosccopak = this.cosccopak.trim();
		else
			this.cosccopak = Constants.BLANKS;
		if (this.cosdcopaf != null)
			this.cosdcopaf = this.cosdcopaf.trim();
		else
			this.cosdcopaf = Constants.BLANKS;
		if (this.cosdocuaf != null)
			this.cosdocuaf = this.cosdocuaf.trim();
		else
			this.cosdocuaf = Constants.BLANKS;
		// Revisa si carga hijos
		if (!Constants.BLANKS.equals(this.cosccosak)) {
			try {
				// DAO para leer SepRelco
				ISeprelcoDAO seprelcoDao = SpringAppContext.getAppContext()
						.getBean(ISeprelcoDAO.class);
				// Busca registros por clave de concepto
				relcos = seprelcoDao.findByConcept(this.cosccosak);
			} catch (Exception e) {/* Error cargando registros */
				LogLogger.getInstance(this.getClass()).logger(
						ExceptionUtils.getFullStackTrace(e), LogLogger.ERROR);
			}
		}
		// Descripcion concepto padre
		if (!Constants.BLANKS.equals(this.cosccopak)) {
			try {
				// DAO para leer Sepconce
				ISepconceDAO sepconceDao = SpringAppContext.getAppContext()
						.getBean(ISepconceDAO.class);
				// Busca concepto padre
				Sepconce pconce = sepconceDao.findById(this.cosccopak);
				// Asigna descripcion
				this.cosdcopaf = pconce.getCosdcosaf();
			} catch (Exception e) {/* Error cargando registros */
				LogLogger.getInstance(this.getClass()).logger(
						ExceptionUtils.getFullStackTrace(e), LogLogger.ERROR);
			}
		}
	}

	@Override
	public void prepareToUpdate() {

	}

	/**
	 * @return the relcos
	 */
	public List<Seprelco> getRelcos() {
		if (relcos == null)
			relcos = new ArrayList<Seprelco>();
		return relcos;
	}

	/**
	 * @param relcos
	 *            the relcos to set
	 */
	public void setRelcos(List<Seprelco> relcos) {
		this.relcos = relcos;
	}

	/**
	 * @return the cosdcopaf
	 */
	public String getCosdcopaf() {
		return cosdcopaf;
	}

	/**
	 * @param cosdcopaf
	 *            the cosdcopaf to set
	 */
	public void setCosdcopaf(String cosdcopaf) {
		this.cosdcopaf = cosdcopaf;
	}

	/**
	 * @return the cosdocuaf
	 */
	public String getCosdocuaf() {
		return cosdocuaf;
	}

	/**
	 * @param cosdocuaf
	 *            the cosdocuaf to set
	 */
	public void setCosdocuaf(String cosdocuaf) {
		this.cosdocuaf = cosdocuaf;
	}

}
