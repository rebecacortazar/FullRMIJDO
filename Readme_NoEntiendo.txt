Despu�s del commit hacemos uso del objeto, que deber�a estar vacio puesto que no hay detach por ning�n sitio, y sin 
embargo mantiene los valores.

http://www.datanucleus.org/products/datanucleus/jdo/object_lifecycle.html

No tenemos ni detach all on commit, tampoco retain Values, as� que los atributos de user deber�an estar a nulos despues del commit
 y no lo est�n.