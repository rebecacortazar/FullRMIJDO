Después del commit hacemos uso del objeto, que debería estar vacio puesto que no hay detach por ningún sitio, y sin 
embargo mantiene los valores.

http://www.datanucleus.org/products/datanucleus/jdo/object_lifecycle.html

No tenemos ni detach all on commit, tampoco retain Values, así que los atributos de user deberían estar a nulos despues del commit
 y no lo están.