RecyclerView

getAdapterPosition() devuelve la posicion del elemento en tu adaptador  - 1 no position
getLayoutPosition() devuelve la posicion del elemento en tu adaptador antes de haber sido actualizado su contenido ( por si Eliminas una celda)
getOldPosition() cuando este inicio una animacion  -1 si la animacion a sido detenida
Validariamos de esta forma:
if(position!= RecyclerView.NO_POSITION){
Log.d("LogDelete", "posicion " + position);
}
