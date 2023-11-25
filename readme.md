# Примітка
Намагався зробити CachedDocument за допомогою SQLite,
не вдалося через якісь помилки із SQLite JDBC Driver
тому зробив збереження кешу у Redis базу даних
підняту локально у докері на стандартному поті 6379

```{bash}
docker run -d -p 6379:6379 --name myredis redis
```
