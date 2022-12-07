/*!
* Start Bootstrap - Grayscale v7.0.5 (https://startbootstrap.com/theme/grayscale)
* Copyright 2013-2022 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-grayscale/blob/master/LICENSE)
*/
//
// Scripts
// 

// const emailForm = document.querySelector('form')
// const search = document.querySelector('input')
// const messageOne = document.querySelector('#result')
// emailForm.addEventListener('submit', (e) => {
//     e.preventDefault()
//     const emailaddress = search.value
//     massageOne.textContent = emailaddress
// })



const form=document.querySelector('form');
const input=document.getElementById('item');
let itemsArray=localStorage.getItem('items')?JSON.parse(localStorage.getItem('items')):[];
localStorage.setItem('items',JSON.stringify(itemsArray));
const data = JSON.parse(localStorage.getItem('items'));

form.addEventListener('submit', function (e) {
    e.preventDefault();
    itemsArray.push(input.value);
    localStorage.setItem('items',JSON.stringify(itemsArray));
    input.value="";
});

clearButton.addEventListener('click', function() {
    localStorage.clear();
})


window.addEventListener('DOMContentLoaded', event => {

    // Navbar shrink function
    var navbarShrink = function () {
        const navbarCollapsible = document.body.querySelector('#mainNav');
        if (!navbarCollapsible) {
            return;
        }
        if (window.scrollY === 0) {
            navbarCollapsible.classList.remove('navbar-shrink')
        } else {
            navbarCollapsible.classList.add('navbar-shrink')
        }

    };

    // Shrink the navbar 
    navbarShrink();

    // Shrink the navbar when page is scrolled
    document.addEventListener('scroll', navbarShrink);

    // Activate Bootstrap scrollspy on the main nav element
    const mainNav = document.body.querySelector('#mainNav');
    if (mainNav) {
        new bootstrap.ScrollSpy(document.body, {
            target: '#mainNav',
            offset: 74,
        });
    };

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#navbarResponsive .nav-link')
    );
    responsiveNavItems.map(function (responsiveNavItem) {
        responsiveNavItem.addEventListener('click', () => {
            if (window.getComputedStyle(navbarToggler).display !== 'none') {
                navbarToggler.click();
            }
        });
    });

});