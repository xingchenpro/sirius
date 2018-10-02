/**
 *@author :hly
 *@github :github.com/SiriusHly
 @blog :blog.csdn.net/Sirius_hly
 *@date :2018/8/4
 */
var nav_a = null;
var navs  = document.getElementById('nav').getElementsByTagName('a');
nav_a = navs[0];
for(var i = 1;i<navs.length;i++){
    if(window.location.href.indexOf(navs[i].href)>=0)
        nav_a = navs[i];
}
nav_a.id = 'current_nav';

