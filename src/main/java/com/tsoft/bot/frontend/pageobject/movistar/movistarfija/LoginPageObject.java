package com.tsoft.bot.frontend.pageobject.movistar.movistarfija;

import org.openqa.selenium.By;

public class LoginPageObject {

    public static String TXT_CODIGO_ATIS_USUARIO = "//input[@name='username']";
    public static String BTN_CONTINUAR_          = "//a[contains(text(),'Continuar')]";
    public static String BTN_CONTRASENIA         = "password";
    public static String BTN_INICIAR_SESION      = "//a[contains(text(),'Ingresar')]";
    public static String BTN_ALTAS_NUEVAS        = "/html/body/my-app/main/acciones/div/div/div[1]/form/div/a[1]";
    public static String BTN_CONTINUAR_SVAS      = "//a[text()='CONTINUAR']";
    public static String usernameLocator         = "//input[@name='username']";



    By passwordLocator=By.xpath("/html/body/my-app/main/completelogin/div[2]/div/div/form/div[2]/input");
    By registerBtnLocator=By.xpath("/html/body/my-app/main/login/div[2]/div/div/form/div[2]/a");
    By usernameadminLocator=By.xpath("/html/body/my-app/main/my-login/div/div/div/form/div[2]/div/input");
    By userpassadminLocator=By.xpath("/html/body/my-app/main/my-login/div/div/div/form/div[3]/div/input");
    By ingresoBtnLocator=By.xpath("/html/body/my-app/main/my-login/div/div/div/form/div[4]/div/button");
    By administrarBtnLocator=By.xpath("/html/body/my-app/header/nav/div/div/ul[1]/li[3]/a");
    By visualizartknBtnLocator=By.xpath("/html/body/my-app/main/my-administration/div/div/div/a/div");
    By inputuserLocator=By.xpath("/html/body/my-app/main/numerosasociados/div/div/div/div[2]/div/form/div[1]/input");
    By detailuserLocator=By.xpath("/html/body/my-app/main/numerosasociados/div/div/div/div[4]/table/tbody/tr/td[8]/a");
    By tokenuserLocator=By.xpath("/html/body/my-app/main/my-numerosasociadosdetail/div/div/div/div/form/table/tbody/tr[5]/td[2]");
    By ingresartokenLocator=By.xpath("/html/body/my-app/main/nobiometric/div[2]/div/div/form/div[3]/input");
    By ingresarpassLocator=By.xpath("/html/body/my-app/main/nobiometric/div[2]/div/div/form/div[2]/input");
    By iniciosesionBtnLocator=By.xpath("/html/body/my-app/main/nobiometric/div[2]/div/div/form/div[4]/a");
    By agendmañana=By.xpath("/html/body/my-app/main/saleprocess/div/div/div/app-schedule/div[1]/div[4]/div[2]/div/div[1]/div[1]/div");
    By agendtarde=By.xpath("/html/body/my-app/main/saleprocess/div/div/div/app-schedule/div[1]/div[4]/div[2]/div/div[1]/div[2]/div");
    By numerocelular=By.id("0fullName");


}
