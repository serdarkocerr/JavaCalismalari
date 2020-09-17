Database ve Sİparis adında 2 spring projesi var.
Database projesi database'den veriyi okur ve kafkaya publish eder.
Ayrıca kafkaya girilen siparişleride database'ye kaydeder ve güncel veriyi kafkaya publish eder.

Siparis ise garson ve asci sayfalarına sahip. 

Database 8090 portundan
Siparis 8080 portundan çalışıyor.

Database projesinden verileri publish etmek için 8090 portuna request atılması yeterli oluyor.

Kafka adresleri her iki projede de manual olarak ayarlanıyor.
