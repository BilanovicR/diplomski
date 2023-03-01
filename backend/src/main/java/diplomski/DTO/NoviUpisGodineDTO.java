package diplomski.DTO;

public class NoviUpisGodineDTO {
	private String godinaUpisa;
	private String espbStecenoUkupno;
	private Long studijskiProgramId;
	private Long fakultetId;
	private String brojIndeksa;
	public String getGodinaUpisa() {
		return godinaUpisa;
	}
	public void setGodinaUpisa(String godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}
	public String getEspbStecenoUkupno() {
		return espbStecenoUkupno;
	}
	public void setEspbStecenoUkupno(String espbStecenoUkupno) {
		this.espbStecenoUkupno = espbStecenoUkupno;
	}
	public Long getStudijskiProgramId() {
		return studijskiProgramId;
	}
	public void setStudijskiProgramId(Long studijskiProgramId) {
		this.studijskiProgramId = studijskiProgramId;
	}
	public Long getFakultetId() {
		return fakultetId;
	}
	public void setFakultetId(Long fakultetId) {
		this.fakultetId = fakultetId;
	}
	public String getBrojIndeksa() {
		return brojIndeksa;
	}
	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}
	public NoviUpisGodineDTO(String godinaUpisa, String espbStecenoUkupno, Long studijskiProgramId, Long fakultetId,
			String brojIndeksa) {
		super();
		this.godinaUpisa = godinaUpisa;
		this.espbStecenoUkupno = espbStecenoUkupno;
		this.studijskiProgramId = studijskiProgramId;
		this.fakultetId = fakultetId;
		this.brojIndeksa = brojIndeksa;
	}
	public NoviUpisGodineDTO() {
		super();
	}
	

}
