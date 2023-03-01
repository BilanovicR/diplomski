export class MapeVrednosti {
    
  public static bracniStatusi: Map<String, String> = new Map<String, String>([
    ['0', 'Neoženjen/neudata'],
    ['1', 'Oženjen/udata, živi u vanbračnoj zajednici'],
    ['2', 'Razveden/razvedena'],
    ['3', 'Udovac/udovica'],
  ]);

  public static nacinFinansiranja: Map<String, String> = new Map<String, String>([
    ['0', 'Finansiranje iz budžeta'],
    ['1', 'Samofinansiranje'],
  ]);

  public static tipSmestaja: Map<String, String> = new Map<String, String>([
    ['0', 'Kod roditelja'],
    ['1', 'Iznajmljen stan'],
    ['2', 'Studentski dom'],
    ['3', 'Sopstveni stan'],
    ['4', 'Kod rođaka'],
    ['5', 'Drugo'],
  ]);

  public static izvorSredstava: Map<String, String> = new Map<String, String>([
    ['0', 'Izdržavano lice (od strane roditelja/rođaka)'],
    ['1', 'Lični prihodi (ušteđevina, prihodi od imovine, nasledstvo i sl)'],
    ['2', 'Stipendija koju daje javna uprava (Ministarstvo prosvete, regionalne, opštinske vlasti i dr.)'],
    ['3', 'Kredit koji daje javna uprava (Ministarstvo prosvete, regionalne, opštinske vlasti i dr.'],
    ['4', 'Stipendije firmi i kompanija'],
    ['5', 'Komercijalni kredit'],
    ['6', 'Drugi izvori finansiranja'],
  ]);

  public static izdrzavaDrugaLica: Map<String, String> = new Map<String, String>([
    ['0', 'Ne'],
    ['1', 'Da, dete/decu'],
    ['2', 'Da, suprugu/supruga, partnera/partnerku'],
    ['3', 'Da, roditelje'],
    ['4', 'Da, druga lica'],
  ]);

  public static skolskaSprema: Map<String, String> = new Map<String, String>([
    ['0', 'Osnovna škola ili manje'],
    ['1', 'Srednja škola'],
    ['2', 'Viša ili visoka škola'],
    ['3', 'Magisterijum/master'],
    ['4', 'Doktorat'],
    ['5', 'Nepoznato'],
  ]);

  public static vidPodrske: Map<String, String> = new Map<String, String>([
    ['0', 'Ništa od navedenog'],
    ['1', 'Pomoć u obavljanju osnovnih radnji fakulteta (kretanje, ishrana i sl.)'],
    ['2', 'Arhitektonska dostupnost za osobe koje se otežano kreću i korisnike kolica (prilagođene prostorije, platforme i liftovi'],
    ['3', 'Arhitektonska dostupnost za slepe i slabovide osobe (taktilna signalizacija)'],
    ['4', 'Skeniranje ili prilagođavanje literature u štampanom formatu (uvećana štampa, elektronsi, audio i Brajevo pismo)'],
    ['5', 'Upotreba drugih asistivnih tehnologija'],
    ['6', 'Angažovanje tumača znakovnog jezika'],
    ['7', 'Prevoz do visokoškolske ustanove dostupan osobama sa teškoćama u kretanju'],
    ['8', 'Postojanje induktivnih petlji u visokoškolskoj ustanovi'],
    ['9', 'Pomoć u verbalnom obraćanju'],
    ['10', 'Pomoć u upoznavanju načina funkcionisanja visokoškolske ustanove'],
    ['11', 'Prilagođavanje rasporeda i vremena trajanja akademskih aktivnosti'],
    ['12', 'Pomoć u savladavanju akademskih obaveza (učenje, pisanje seminarskih radova i sl.)'],
  ]);
}
