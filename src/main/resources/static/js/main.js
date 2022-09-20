const btnMenuCerrar  = document.getElementById('cerrar_menu')
const btnMenu = document.querySelector('#menu');
const fondoMenu= document.querySelector('.contenedor-menu')

btnMenu.addEventListener("click",()=>{
    fondoMenu.classList.toggle('mostrarf')
});

btnMenuCerrar.addEventListener("click",()=>{
    fondoMenu.classList.toggle('mostrarf')
})

