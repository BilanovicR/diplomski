export class StudentSV20DTO {

    student: Student;
    skola : StudentSrednjaSkolaDTO;
    detalji: StudentDetaljiDTO;
    
}

export class StudentSV20 {

    student: Student;
    skola : StudentSrednjaSkolaDTO;
    detalji: StudentDetalji;
    
}

export class StudentSrednjaSkolaDTO {
    id : String;
    naziv : String;
    vrstaSkole : String;
    opstina : String;
    grad : String;
    drzava : String;
    godinaZavrsetka : String;
}

export class StudentDetaljiDTO {
    id : String;
    mestoStanovanja : String;
    tipSmestaja : String;
    nacinFinansiranja : String;
    izvorSredstava : String;
    glavniIzvorSredstava : String;
    jeZaposlen: Boolean;
    izdrzavaDrugaLica : String;
    izdrzavalacJeZaposlen :Boolean;
    zanimanjeIzdrzavaoca : String;
    skolskaSpremaOca : String;
    skolskaSpremaMajke : String;
    potrebanVidPodrske : String;
    //SV50
    istaVrstaStudijaNaDrugomFakultetu : Boolean;
    drugiFakultet : String;
    godinaZavrsetkaDrugogFakulteta : String;
    drzavaZavrsetkaDrugogFakulteta : String;

    constructor(dto : StudentDetalji){
        this.id = dto.id;
        this.mestoStanovanja = dto.mestoStanovanja;
        this.tipSmestaja = dto.tipSmestaja;
        this.nacinFinansiranja = dto.nacinFinansiranja;
        this.izvorSredstava = dto.izvorSredstava.join(";");
        this.glavniIzvorSredstava = dto.glavniIzvorSredstava;
        this.jeZaposlen = dto.jeZaposlen;
        this.izdrzavaDrugaLica = dto.izdrzavaDrugaLica.join(";");
        this.izdrzavalacJeZaposlen = dto.izdrzavalacJeZaposlen;
        this.zanimanjeIzdrzavaoca = dto.zanimanjeIzdrzavaoca;
        this.skolskaSpremaOca = dto.skolskaSpremaOca;
        this.skolskaSpremaMajke = dto.skolskaSpremaMajke;
        this.potrebanVidPodrske = dto.potrebanVidPodrske.join(";");
        this.istaVrstaStudijaNaDrugomFakultetu = dto.istaVrstaStudijaNaDrugomFakultetu;
        this.drugiFakultet = dto.drugiFakultet;
        this.godinaZavrsetkaDrugogFakulteta = dto.godinaZavrsetkaDrugogFakulteta;
        this.drzavaZavrsetkaDrugogFakulteta = dto.drzavaZavrsetkaDrugogFakulteta
     }
}

export class Student {
    id: String;
    ime : String;
    prezime : String;
    imeRoditelja : String;
    email : String;
    jmbg : String;
    pol : String;
    fotografijaURL : String;
    datumRodjenja : String;
    mestoRodjenja : String;
    brojTelefona : String;
    brojIndeksa : String;
    brojPasosa : String;
    prebivaliste : String;
    ulica : String;
    naselje : String;
    drzavljanstvo : String;
    nacionalnost : String;
    bracniStatus : String;
    jeDiplomirao : Boolean;
}

export class StudentDetalji {
    id : String;
    mestoStanovanja : String;
    tipSmestaja : String;
    nacinFinansiranja : String;
    izvorSredstava : Array<String> = new Array<String>();
    glavniIzvorSredstava : String;
    jeZaposlen: Boolean;
    izdrzavaDrugaLica : String[] = [];
    izdrzavalacJeZaposlen :Boolean;
    zanimanjeIzdrzavaoca : String;
    skolskaSpremaOca : String;
    skolskaSpremaMajke : String;
    potrebanVidPodrske : Array<String> = new Array<String>();
    //SV50
    istaVrstaStudijaNaDrugomFakultetu : Boolean;
    drugiFakultet : String;
    godinaZavrsetkaDrugogFakulteta : String;
    drzavaZavrsetkaDrugogFakulteta : String;

    constructor( dto : StudentDetaljiDTO){
            this.mestoStanovanja = dto.mestoStanovanja;
            this.tipSmestaja = dto.tipSmestaja;
            this.nacinFinansiranja = dto.nacinFinansiranja;
            this.izvorSredstava = dto.izvorSredstava.split(";");
            this.glavniIzvorSredstava = dto.glavniIzvorSredstava;
            this.jeZaposlen = dto.jeZaposlen;
            this.izdrzavaDrugaLica = dto.izdrzavaDrugaLica.split(";");
            this.izdrzavalacJeZaposlen = dto.izdrzavalacJeZaposlen;
            this.zanimanjeIzdrzavaoca = dto.zanimanjeIzdrzavaoca;
            this.skolskaSpremaOca = dto.skolskaSpremaOca;
            this.skolskaSpremaMajke = dto.skolskaSpremaMajke;
            this.potrebanVidPodrske = dto.potrebanVidPodrske.split(";");
            this.istaVrstaStudijaNaDrugomFakultetu = dto.istaVrstaStudijaNaDrugomFakultetu;
            this.drugiFakultet = dto.drugiFakultet;
            this.godinaZavrsetkaDrugogFakulteta = dto.godinaZavrsetkaDrugogFakulteta;
            this.drzavaZavrsetkaDrugogFakulteta = dto.drzavaZavrsetkaDrugogFakulteta
         }
}