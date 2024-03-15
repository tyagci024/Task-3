Bu projedeki livedata kullanımın avantajları ve çıkardığım kazanımlarım şu şekildedir;
Bu projede livedata kullanmanın en büyük faydalarından biri, veri değişikliklerini UI'ya direkt olarak yansıtabildim
Özellikle oyunda, oyuncunun yaptığı hamlelerin sonucunda resultMessageObs counterOberser i livedata ile takip edebildim ve bu hamlelerin hemen UI'de görüntülenmesini sağladım.
activityViewModelsi ele alcak olursak da viewmodelimi activitiy düzeyinde tutarak her hangi fragment değiştirmemde yaşam döngülerinin yeniden oluşması durumunda viewmodel tekrar başlatılmadı ve random oluşan değişkenlerim fragmentlar arası geçişte bile sabit kaldı.
