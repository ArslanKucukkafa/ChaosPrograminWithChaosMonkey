Chaos Monkey, Netflix tarafından geliştirilmiş ve genellikle kaos mühendisliği kapsamında kullanılan bir araçtır. Bu araç, üretim ortamında hizmetlerin rastgele kesintiye uğratılması yoluyla sistemin dayanıklılığını ve esnekliğini test eder. Amaç, sistemdeki zayıflıkları ortaya çıkarmak ve bunları gidermek için önlemler alarak, beklenmedik hatalara karşı sistemin sağlamlığını artırmaktır.

Chaos Monkey'nin Özellikleri ve Kullanımı:
Rastgele Kesinti: Chaos Monkey, belirli zamanlarda rastgele hizmetleri veya sunucuları devre dışı bırakır.
Dayanıklılık Testi: Bu kesintiler, sistemin otomatik hata tolerans mekanizmalarını ve yedekleme süreçlerini test eder.
Sürekli İyileştirme: Kaos mühendisliği ilkeleri doğrultusunda, elde edilen sonuçlar sistemin daha dayanıklı hale getirilmesi için kullanılır.
Otomasyon: Chaos Monkey genellikle otomatik olarak çalıştırılır ve sürekli entegrasyon/dağıtım süreçlerine entegre edilir.
Chaos Monkey'nin Avantajları:
Zayıflıkların Keşfi: Sistem zayıflıklarını ve hata toleransında boşlukları ortaya çıkarır.
Dayanıklılık Artışı: Belirlenen zayıflıkların düzeltilmesi, sistemin genel dayanıklılığını artırır.
Gerçek Dünya Senaryoları: Gerçek dünyada karşılaşılabilecek beklenmedik hataları simüle eder, böylece hazırlıklı olmayı sağlar.

Chaos Monkey'in Kapsamı:
Chaos Monkey, Netflix'in daha geniş bir kaos mühendisliği araç setinin bir parçasıdır. Bu araç seti, "Simian Army" olarak adlandırılır ve farklı türde kaos testleri gerçekleştiren diğer araçları da içerir (örneğin, Latency Monkey, Doctor Monkey, Conformity Monkey).

Kaos mühendisliği, modern dağıtık sistemlerin ve mikro hizmet mimarilerinin güvenilirliğini artırmak için kritik bir yaklaşımdır ve Chaos Monkey, bu alanın en bilinen araçlarından biridir . 

[Kaos mühendisliği ilkeleri](ARASTIRMA.md)


## Projenin amacı
Bu projenin amacı, Chaos Monkey'nin temel özelliklerini ve kullanımını açıklamak, avantajlarını ve kapsamını belirtmek ve kaos mühendisliği kavramını genel olarak tanıtmaktır. Ayrıca, Chaos Monkey'nin nasıl kullanıldığını ve nasıl entegre edildiğini gösteren örnekler verilecektir.
Chaos Monkey kullanımı sayesinde projenin gecikmeli isteklerde, hata fırlatma durumlarında, hafıza doluluk durumlarında, CPU yüklenme durumlarında ve uygulamanın öldürülmesi durumlarında nasıl davranacağını test edebilir ve karşı karşıya kalabileceği durumları gözlemleyebiliriz.

## Kullanım

Chaos Monkey, genellikle üretim ortamında kullanılır ve hizmetlerin rastgele kesintiye uğratılması yoluyla sistemin dayanıklılığını test eder. Ancak, geliştirme ve test ortamlarında da kullanılabilir. Chaos Monkey, hizmetlerin ve sunucuların rastgele kesintiye uğratılmasını sağlayan bir dizi özelliğe sahiptir. Bu özellikler, hizmetlerin performansını, dayanıklılığını ve esnekliğini test etmek için kullanılır. Chaos Monkey, hizmetlerin ve sunucuların rastgele kesintiye uğratılmasını sağlayan bir dizi özelliğe sahiptir. Bu özellikler, hizmetlerin performansını, dayanıklılığını ve esnekliğini test etmek için kullanılır.

Aşşağıda Chaos Monkey'nin kullanımı için örnek bir curl komutu verilmiştir. Bu istek, Chaos Monkey'nin etkinleştirilmesini saglar.

```bash
curl -X 'POST' \
  'http://hybrid-circle-426017-j4.rj.r.appspot.com/actuator/chaosmonkey/enable' \
  -H 'accept: */*' \
  -d ''
```

Aşşağıda Chaos Monkey'nin kullanımı için örnek bir curl komutu verilmiştir. Bu istek, Chaos Monkey nin uygulmadaki üst alt sınırları belirlemek, hata fırlatma durumlarını belirlemek, uygulamanın öldürülme durumlarını belirlemek, hafıza doluluk durumlarını belirlemek ve CPU yüklenme durumlarını belirlemek için kullanılır. Aşşagıdaki istek sayesinde Chaos Monkey'nin uygulamada nasıl davranacağını belirleyebiliriz.

```bash
curl -X 'POST' \
  'http://hybrid-circle-426017-j4.rj.r.appspot.com/actuator/chaosmonkey/assaults' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "level": 10000,
  "deterministic": true,
  "latencyRangeStart": 2147483647,
  "latencyRangeEnd": 2147483647,
  "latencyActive": true,
  "exceptionsActive": true,
  "exception": {
    "type": "string",
    "method": "string",
    "arguments": [
      {
        "type": "string",
        "value": "string"
      }
    ]
  },
  "killApplicationActive": true,
  "killApplicationCronExpression": "string",
  "memoryActive": true,
  "memoryMillisecondsHoldFilledMemory": 2147483647,
  "memoryMillisecondsWaitNextIncrease": 30000,
  "memoryFillIncrementFraction": 1,
  "memoryFillTargetFraction": 0.95,
  "memoryCronExpression": "string",
  "cpuActive": true,
  "cpuMillisecondsHoldLoad": 2147483647,
  "cpuLoadTargetFraction": 1,
  "cpuCronExpression": "string",
  "watchedCustomServices": [
    "string"
  ]
}'
```

Aşşağıda Chaos Monkey'nin kullanımı için örnek bir curl komutu verilmiştir. Bu istek, Chaos Monkey'nin hangi sınıfları izleyeceğini belirler. Chaos Monkey, izlenen sınıfların metotlarını ve hizmetlerini rastgele kesintiye uğratır. Aşşağıdaki istek sayesinde Chaos Monkey'nin hangi sınıfları izleyeceğini belirleyebiliriz.
```bash
curl -X 'POST' \
  'http://hybrid-circle-426017-j4.rj.r.appspot.com/actuator/chaosmonkey/watchers' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "controller": true,
  "restController": true,
  "service": true,
  "repository": true,
  "component": true,
  "restTemplate": true,
  "webClient": true,
  "actuatorHealth": true,
  "beans": [
    "string"
  ]
}'
```

Chaos Monkey için istediginiz yapılandırmaları yapabilirsiniz. Chaos Monkey'nin uygulamada nasıl davranacağını belirleyebilirsiniz. Chaos Monkey'nin hangi sınıfları izleyeceğini belirleyebilirsiniz. Chaos Monkey'nin etkinleştirilmesini sağlayabilirsiniz. Daha sonra test etmek için aşşagıdaki istekleri kullanabilirsiniz.

```bash
curl -X 'GET' \
  'http://hybrid-circle-426017-j4.rj.r.appspot.com/projects' \
  -H 'accept: */*'
```

```bash
curl -X 'PUT' \
  'http://hybrid-circle-426017-j4.rj.r.appspot.com/projects' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "id": 0,
  "title": "string",
  "description": "string",
  "published": true
}'
```

```bash
curl -X 'POST' \
  'http://hybrid-circle-426017-j4.rj.r.appspot.com/projects' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "title": "string",
  "description": "string",
  "published": true
}'
```

```bash
curl -X 'DELETE' \
  'http://hybrid-circle-426017-j4.rj.r.appspot.com/projects/{your-entiy-id}' \
  -H 'accept: */*'
```

Bu sayede sistemdeki eksiklikleri ve hataları gözlemleyebilir ve düzeltebilirsiniz.

[Project Swagger](https://hybrid-circle-426017-j4.rj.r.appspot.com//swagger-ui/index.html) adresinden incelenebilir.

> **Note:** Bu projeyi kendi postman yada insomnia api istemcinizde kullanmak için ./tool altındaki dosyaları kullanabilirsiniz.

> **Note:** Swagger da cors hatası ama örnek requet body ve response ları görebilirsiniz. 


### Projeyi hazırlayanlar

| Ad     | soyad     | ögrenci no |
|--------|-----------|------------|
| İdris  | Aktaş     | 190541056  |
| Arslan | Küçükkafa | 190541050  |

[Döküman](https://arslankucukkafa.000webhostapp.com/2024/06/yazilim-muhendisligi-guncel-konular-proje)