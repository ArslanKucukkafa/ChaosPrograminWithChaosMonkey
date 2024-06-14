# KAOS MÜHENDİSLİĞİNİN İLKELERİ
Son Güncelleme: 2019 Mart (değişiklikler)

Kaos Mühendisliği, bir sistemin üretim ortamında zorlayıcı koşullara dayanma yeteneğine güven oluşturmak amacıyla sistem üzerinde deneyler yapma disiplinidir.

Büyük ölçekli, dağıtık yazılım sistemlerindeki ilerlemeler, yazılım mühendisliği için oyunu değiştiriyor. Bir endüstri olarak, geliştirme esnekliğini ve dağıtım hızını artıran uygulamaları hızla benimsiyoruz. Bu faydaların hemen ardından acil bir soru gelir: Üretime koyduğumuz karmaşık sistemlere ne kadar güvenebiliriz?

Bir dağıtık sistemdeki tüm bireysel hizmetler düzgün çalışsa bile, bu hizmetler arasındaki etkileşimler öngörülemeyen sonuçlara neden olabilir. Öngörülemeyen sonuçlar, üretim ortamlarını etkileyen nadir ancak yıkıcı gerçek dünya olaylarıyla birleştiğinde, bu dağıtık sistemleri doğası gereği kaotik hale getirir.

Sistem çapında anormal davranışlar olarak ortaya çıkmadan önce zayıf noktaları belirlememiz gerekiyor. Sistemik zayıflıklar, bir hizmet kullanılamadığında yanlış geri dönüş ayarları, yanlış ayarlanmış zaman aşımından kaynaklanan yeniden deneme fırtınaları, bir aşağı akış bağımlılığı çok fazla trafik aldığında kesintiler, bir arıza noktasının çökmesiyle başlayan zincirleme arızalar vb. şeklinde olabilir. En önemli zayıf noktaları, üretimde müşterilerimizi etkilemeden önce proaktif olarak ele almalıyız. Bu sistemlerde var olan kaosu yönetmenin, artan esneklik ve hızdan yararlanmanın ve bu sistemlerin temsil ettiği karmaşıklığa rağmen üretim dağıtımlarımıza güven duymanın bir yoluna ihtiyacımız var.

Deneysel, sistem tabanlı bir yaklaşım, dağıtık sistemlerdeki kaosu büyük ölçekte ele alır ve bu sistemlerin gerçekçi koşullara dayanma yeteneğine güven oluşturur. Bir dağıtık sistemin davranışını, kontrollü bir deney sırasında gözlemleyerek öğreniriz. Buna Kaos Mühendisliği diyoruz.

## UYGULAMADA KAOS
Dağıtık sistemlerin büyük ölçekteki belirsizliğini özel olarak ele almak için, Kaos Mühendisliği, sistemik zayıflıkları ortaya çıkarmak için deneyler yapma süreci olarak düşünülebilir. Bu deneyler dört adımı izler:

1. Sistemin normal davranışını gösteren bazı ölçülebilir çıktılar olarak 'durağan durumu' tanımlayarak başlayın.
2. Bu durağan durumun hem kontrol grubunda hem de deney grubunda devam edeceğini varsayın.
3. Sunucuların çökmesi, sabit disklerin arızalanması, ağ bağlantılarının kesilmesi gibi gerçek dünya olaylarını yansıtan değişkenler ekleyin.
4. Kontrol grubu ile deney grubu arasında durağan durumda bir fark arayarak hipotezi çürütmeye çalışın.

Durağan durumu bozmak ne kadar zorsa, sistemin davranışına olan güvenimiz o kadar artar. Bir zayıflık ortaya çıkarsa, bu davranışın sistem genelinde ortaya çıkmadan önce iyileştirilmesi gereken bir hedefimiz olur.

## GELİŞMİŞ İLKELER
Aşağıdaki ilkeler, yukarıda açıklanan deney süreçlerine uygulanan Kaos Mühendisliğinin ideal bir uygulamasını tanımlar. Bu ilkelerin ne ölçüde takip edildiği, büyük ölçekli bir dağıtık sisteme olan güvenimizle güçlü bir şekilde ilişkilidir.

### Durağan Durum Davranışı Etrafında Hipotez Kurun
Sistemin içsel özelliklerinden ziyade ölçülebilir çıktısına odaklanın. Kısa bir süre boyunca bu çıktının ölçümleri, sistemin durağan durumu için bir vekil oluşturur. Genel sistemin iş hacmi, hata oranları, gecikme yüzdeleri vb. durağan durumu temsil eden ilgilenilen metrikler olabilir. Deneyler sırasında sistemik davranış kalıplarına odaklanarak, Kaos sistemin nasıl çalıştığını doğrulamaya çalışmak yerine çalıştığını doğrular.

### Gerçek Dünya Olaylarını Çeşitlendirin
Kaos değişkenleri gerçek dünya olaylarını yansıtır. Olayları potansiyel etkiye veya tahmini sıklığa göre önceliklendirin. Sunucuların çökmesi gibi donanım arızaları, bozuk yanıtlar gibi yazılım hataları ve trafik artışı veya ölçekleme olayı gibi arıza dışı olaylara karşılık gelen olayları düşünün. Durağan durumu bozabilecek herhangi bir olay, bir Kaos deneyinde potansiyel bir değişkendir.

### Deneyleri Üretimde Çalıştırın
Sistemler, ortama ve trafik modellerine bağlı olarak farklı davranır. Kullanım davranışı herhangi bir zamanda değişebileceğinden, gerçek trafiği örneklemek, istek yolunu güvenilir bir şekilde yakalamanın tek yoludur. Hem sistemin nasıl çalıştırıldığına dair otantiklik hem de mevcut dağıtılmış sistemle ilgili olmak için, Kaos deneylerini doğrudan üretim trafiğinde yapmayı tercih eder.

### Deneyleri Sürekli Çalışacak Şekilde Otomatikleştirin
Deneyleri manuel olarak yürütmek zahmetlidir ve nihayetinde sürdürülebilir değildir. Deneyleri otomatikleştirin ve sürekli çalıştırın. Kaos Mühendisliği, hem orkestrasyonu hem de analizi yönlendirmek için otomasyonu sisteme dahil eder.

### Patlama Yarıçapını Minimize Edin
Üretimde deney yapmak, gereksiz müşteri sıkıntısına neden olabilir. Kısa vadeli bazı olumsuz etkilere izin verilmesi gerekse de, Kaos Mühendisinin sorumluluğu ve yükümlülüğü, deneylerden kaynaklanan olumsuz etkilerin en aza indirildiğinden ve kontrol altına alındığından emin olmaktır.

Kaos Mühendisliği, dünyanın en büyük ölçekli operasyonlarında yazılımın nasıl tasarlandığını ve geliştirildiğini şimdiden değiştiren güçlü bir uygulamadır. Diğer uygulamalar hız ve esnekliği ele alırken, Kaos özellikle bu dağıtık sistemlerdeki sistemik belirsizlikle ilgilenir. Kaos İlkeleri, büyük ölçeklerde hızlı yenilik yapma güvenini sağlar ve müşterilere hak ettikleri yüksek kaliteli deneyimleri sunar.

Kaos İlkelerinin uygulanması ve Kaos Topluluğundaki sürekli tartışmaya katılın.

Kaynak
[PRINCIPLES OF CHAOS ENGINEERING](https://principlesofchaos.org/?lang=ENcontent)