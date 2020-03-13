package com.tsoft.bot.frontend.steps.movistar;

import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import com.tsoft.bot.frontend.utility.Sleeper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.tsoft.bot.frontend.pageobject.movistar.movistarfija.AltasNuevasPageObject.*;
import static com.tsoft.bot.frontend.pageobject.movistar.movistarfija.LoginPageObject.*;

public class MovistarFija {

    public static final String CAMPO_REEMPLAZAR = "*Field*";
    private static final String EXCEL_WEB = "excel/MovistarFija.xlsx";
    private static final String LOGIN_WEB = "Login";
    private static final String COLUMNA_USUARIO = "Usuario";
    private static final String COLUMNA_CONTRASENIA = "Contraseña";
    private static final String COLUMNA_TIPO_DOCUMENTO = "Tipo Documento";
    private static final String COLUMNA_NUMERO_DOCUMENTO = "Numero Documento";
    private static final String COLUMNA_DEPARTAMENTO = "Departamento";
    private static final String COLUMNA_PROVINCIA = "Provincia";
    private static final String COLUMNA_DISTRITO = "Distrito";
    private static final String COLUMNA_APELLIDO_CLIENTE = "Apellido Cliente";
    private static final String COLUMNA_NOMBRE_CLIENTE = "Nombre Cliente";
    private static final String COLUMNA_FECHA_NACIMIENTO_CLIENTE = "Fecha Nacimiento Cliente";
    private static final String COLUMNA_DEPARTAMENTO_CLIENTE = "Departamento Cliente";
    private static final String COLUMNA_PROVINCIA_CLIENTE = "Provincia Cliente";
    private static final String COLUMNA_DISTRITO_CLIENTE = "Distrito Cliente";
    private static final String COLUMNA_NOMBRE_MADRE_CLIENTE = "Nombre Madre Cliente";
    private static final String COLUMNA_NOMBRE_PADRE_CLIENTE = "Nombre Padre Cliente";
    private static final String COLUMNA_LUGAR_UBICACION = "Lugar Ubicación";
    private static final String COLUMNA_NOMBRE_PRODUCTO = "Nombre Producto";
    private static final String COLUMNA_TIPO_PRODUCTO = "Tipo Producto";
    private static final String COLUMNA_USER = "Usuario Admin";
    private static final String COLUMNA_PWD = "Contraseña Admin";
    private static final String URL_MOVISTAR_FIJA = "http://tdp-web-venta-fija-qa.mybluemix.net/acciones";
    private static final String URL_MOVISTAR_FIJA_2 = "https://tdp-admin-venta-fija-qa.mybluemix.net";
    private static GenerateWord generateWord = new GenerateWord();
    private WebDriver driver;

    public MovistarFija() {
        this.driver = Hook.getDriver();
    }

    @Given("^Ir a la pagina de Movistar Fija$")
    public void irALaPaginaDeMovistarFija() throws Throwable {
        try {
            driver.get(URL_MOVISTAR_FIJA);
            Sleeper.Sleep(1900);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se inició correctamente la página Movistar");
            generateWord.sendText("Se inició correctamente la página Movistar");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Ingresar codigo ATIS / Usuario \"([^\"]*)\"$")
    public void ingresarCodigoATISUsuario(String casoDePrueba) throws Throwable {
        try {
            int movistarFija = Integer.parseInt(casoDePrueba) - 1;
            driver.findElement(By.xpath(TXT_CODIGO_ATIS_USUARIO)).clear();
            String codigoAtis = getData().get(movistarFija).get(COLUMNA_USUARIO);
            driver.findElement(By.xpath(TXT_CODIGO_ATIS_USUARIO)).sendKeys(codigoAtis);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó el usuario : " + codigoAtis);
            generateWord.sendText("Se ingresó el codigo ATIS / Usuario ");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Click en el boton Continuar$")
    public void clickEnElBotonContinuar() throws Exception {
        try {
            driver.findElement(By.xpath(BTN_CONTINUAR_)).click();
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se dió click en el boton 'Continuar'");
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @When("^Validar si el codigo ATIS y ingresar contraseña \"([^\"]*)\"$")
    public void validarSiElCodigoATISYIngresarContraseña(String casoDePrueba) throws Throwable {
        try {
            int movistarFija = Integer.parseInt(casoDePrueba) - 1;
            String contrasenia = getData().get(movistarFija).get(COLUMNA_CONTRASENIA);
            String getUsuario = driver.findElement(By.xpath(TXT_CODIGO_ATIS_USUARIO)).getAttribute("value");

            if (!getUsuario.equals(getData().get(movistarFija).get(COLUMNA_USUARIO))) {
                driver.findElement(By.id(TXT_CODIGO_ATIS_USUARIO)).sendKeys(getData().get(movistarFija).get(COLUMNA_USUARIO));
                ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó el usuario : " + getData().get(movistarFija).get(COLUMNA_USUARIO));

            }
            driver.findElement(By.id(BTN_CONTRASENIA)).sendKeys(contrasenia);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó la contraseña'");
            generateWord.sendText("Se ingresó el usuario y contraseña");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }

    }

    @And("^Ingresa a la web admin$")
    public void ingresaALaWebAdmin() throws Throwable {
        try {
            ((JavascriptExecutor) driver).executeScript("window.open()");
            Thread.sleep(2000);
            String pagina1 = driver.getWindowHandle();
            int numero = 1;
            for (String tabs : driver.getWindowHandles()) {
                if (numero == 2) {
                    driver.switchTo().window(tabs);
                    driver.get(URL_MOVISTAR_FIJA_2);
                    ExtentReportUtil.INSTANCE.stepPass(driver, "Se abre web admin");
                    generateWord.sendText("Se abre la web admin");
                    generateWord.addImageToWord(driver);
                }
                numero++;
            }
            Sleeper.Sleep(1900);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se inició correctamente la página Movistar");
            generateWord.sendText("Se inició correctamente la página Movistar");
            generateWord.addImageToWord(driver);

        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @When("^Ingresar usuario admin y la contraseña \"([^\"]*)\"$")
    public void ingresarUsuarioAdminYLaContraseña(String casoDePrueba) throws Throwable {
        try {
            int movistarFija = Integer.parseInt(casoDePrueba) - 1;
            driver.findElement(By.name(TXT_CODIGO_ATIS_USUARIO)).clear();
            String useradmin = getData().get(movistarFija).get(COLUMNA_USER);
            String pwdadmin = getData().get(movistarFija).get(COLUMNA_PWD);
            driver.findElement(By.xpath(usernameLocator)).sendKeys(useradmin);
            driver.findElement(By.xpath(passwordLocator)).sendKeys(pwdadmin);
            ExtentReportUtil.INSTANCE.stepPass(driver, "    Se ingresa el usuario y la contraseña");
            generateWord.sendText("Se ingresa el usuario y la contraseña");
            generateWord.addImageToWord(driver);
            Thread.sleep(2000);
            driver.findElement(ingresoBtnLocator).click();
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresa a la web admin");
            generateWord.sendText("Se ingresa a la web admin");
            generateWord.addImageToWord(driver);
            Thread.sleep(2000);
        }
        catch(Exception e) {
            System.out.println("Error en " + e.getMessage());
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    @And("^Click en Administracion admin$")
    public void clickEnAdministracionAdmin() throws Throwable {
        try {


            driver.findElement(administrarBtnLocator).click(); //  Administración
            Thread.sleep(2000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresa a los modulos");
            generateWord.sendText("Se ingresa a los modulos");
            generateWord.addImageToWord(driver);
        }
        catch(Exception e) {
            System.out.println("Error en " + e.getMessage());
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Click en visualizar tokens admin$")
    public void clickEnVisualizarTokensAdmin() throws Throwable {
        try{
            driver.findElement(visualizartknBtnLocator).click();
            Thread.sleep(2000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó al modulo visualizar tokens");
            generateWord.sendText("Se ingresó al modulo visualizar tokens");
            generateWord.addImageToWord(driver);

        }
        catch(Exception e) {
            System.out.println("Error en " + e.getMessage());
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Buscar con codigo atis \"([^\"]*)\"$")
    public void buscarConCodigoAtis(String casoDePrueba) throws Throwable {
        try {
            int movistarFija = Integer.parseInt(casoDePrueba) - 1;
            String codigoAtis = getData().get(movistarFija).get(COLUMNA_USUARIO);
            driver.findElement(inputuserLocator).sendKeys(codigoAtis);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se escribe el cod atis");
            generateWord.sendText("Se escribe el cod atis");
            generateWord.addImageToWord(driver);
            Thread.sleep(2000);
        }
        catch(Exception e) {
            System.out.println("Error en " + e.getMessage());
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }



    @And("^click en ver cod atis$")
    public void clickEnVerCodAtis() throws Throwable {
        try {
            driver.findElement(inputuserLocator).sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se busca el cod atis");
            generateWord.sendText("Se busca el cod atis");
            generateWord.addImageToWord(driver);
            Thread.sleep(2000);
            driver.findElement(detailuserLocator).click();
            Thread.sleep(2000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresa al cod atis");
            generateWord.sendText("Se ingresa al cod atis");
            generateWord.addImageToWord(driver);
        }
        catch(Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }

    }

    @And("^regresar a la web de ventas$")
    public void regresarALaWebDeVentas() throws Exception {
        try {

            String token = driver.findElement(tokenuserLocator).getText();
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se obtiene el token");
            generateWord.sendText("Se obtiene el token");
            generateWord.addImageToWord(driver);
            Thread.sleep(2000);
            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
            driver.close();
            driver.switchTo().window(tabs2.get(0));
            driver.findElement(ingresartokenLocator).sendKeys(token);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se coloca el token");
            generateWord.sendText("Se coloca el token");
            generateWord.addImageToWord(driver);

        }
        catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Click en el boton Iniciar Sesion$")
    public void clickEnElBotonIniciarSesion() throws Exception {
        try {
            driver.findElement(By.xpath(BTN_INICIAR_SESION)).click();
            Sleeper.Sleep(3000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se dió click en el boton 'Iniciar Sesión'");
            generateWord.sendText("Se dió click en el boton 'Iniciar Sesión'");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Seleccionar en el menu Altas Nuevas$")
    public void seleccionarEnElMenuAltasNuevas() throws Throwable {
        try {
            Sleeper.Sleep(1500);
            driver.findElement(By.xpath(BTN_ALTAS_NUEVAS)).click();
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se dió click en la opción 'Altas Nuevas'");
            Sleeper.Sleep(1000);
            generateWord.sendText("Se dió click en la opción 'Altas Nuevas'");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @When("^Ingresar datos del cliente \"([^\"]*)\"$")
    public void ingresarDatosDelCliente(String casoDePrueba) throws Throwable {
        try {
            int movistarFija = Integer.parseInt(casoDePrueba) - 1;
            String tipoDocumento = getData().get(movistarFija).get(COLUMNA_TIPO_DOCUMENTO);
            Select select = new Select(driver.findElement(By.id(CBO_TIPO_DOCUMENTO)));
            select.selectByVisibleText(tipoDocumento);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se elegió el Tipo Documento : " + tipoDocumento);
            String numeroDocumento = getData().get(movistarFija).get(COLUMNA_NUMERO_DOCUMENTO);
            switch (tipoDocumento) {
                case "DNI":
                    driver.findElement(By.id(TXT_DNI)).sendKeys(numeroDocumento);
                    ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó el Número Documento : " + numeroDocumento);

                    break;
                case "Carné de Extranjeria":
                    driver.findElement(By.id(TXT_CE)).sendKeys(numeroDocumento);
                    ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó el Número Documento : " + numeroDocumento);
                    break;
                case "Pasaporte":
                    driver.findElement(By.id(TXT_PASAPORTE)).sendKeys(numeroDocumento);
                    ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó el Número Documento : " + numeroDocumento);
                    break;
                case "RUC":
                    driver.findElement(By.id(TXT_RUC)).sendKeys(numeroDocumento);
                    ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó el Número Documento : " + numeroDocumento);
                    break;
                case "Otros Extranjeros - Aut. SNM":
                    driver.findElement(By.id(TXT_OTROS)).sendKeys(numeroDocumento);
                    ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó el Número Documento : " + numeroDocumento);
                    break;
            }
            String departamento = getData().get(movistarFija).get(COLUMNA_DEPARTAMENTO);
            Select select2 = new Select(driver.findElement(By.id(CBO_DEPARTAMENTO)));
            select2.selectByVisibleText(departamento);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se elegió el Departamento : " + departamento);
            Sleeper.Sleep(500);
            String provincia = getData().get(movistarFija).get(COLUMNA_PROVINCIA);
            Select select3 = new Select(driver.findElement(By.id(CBO_PROVINCIA)));
            select3.selectByVisibleText(provincia);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se elegió el Pronvicia : " + provincia);
            Sleeper.Sleep(500);
            String distrito = getData().get(movistarFija).get(COLUMNA_DISTRITO);
            Select select4 = new Select(driver.findElement(By.id(CBO_DISTRITO)));
            select4.selectByVisibleText(distrito);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se elegió el Distrito : " + distrito);
            Sleeper.Sleep(1000);
            generateWord.sendText("Se ingresó los datos del cliente");
            generateWord.addImageToWord(driver);
            scrollBar();
            scrollBar();
            driver.findElement(By.xpath(BTN_EVALUAR)).click();
            Sleeper.Sleep(3000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se dió click en el boton 'Evaluar'");
            scrollBar();
            scrollBar();
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se dió click en el boton 'Continuar'");
            generateWord.sendText("Se dió en el botón 'Continuar'");
            generateWord.addImageToWord(driver);
            Sleeper.Sleep(3000);
            scrollBar();
            driver.findElement(By.xpath(BTN_CONTINUAR_DC)).click();
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "PASS");

        } catch (Exception e) {
            System.out.println("Error en " + e.getMessage());
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Ingresar lugar de ubicacion \"([^\"]*)\"$")
    public void ingresarLugarDeUbicacion(String casoDePrueba) throws Throwable {
        try {

            int movistarFija = Integer.parseInt(casoDePrueba) - 1;
            driver.switchTo().activeElement();
            driver.switchTo().defaultContent();
            Sleeper.Sleep(300);
            Thread.sleep(5000);
            String lugarUbicacion = getData().get(movistarFija).get(COLUMNA_LUGAR_UBICACION);
            driver.findElement(By.id(TXT_LUGAR_UBICACION)).sendKeys(lugarUbicacion);
            driver.findElement(By.id(TXT_LUGAR_UBICACION)).sendKeys(Keys.SPACE);
            driver.findElement(By.id(TXT_LUGAR_UBICACION)).sendKeys(Keys.ENTER);
            driver.findElement(By.id(TXT_LUGAR_UBICACION)).sendKeys(Keys.SPACE);
            driver.findElement(By.id(TXT_LUGAR_UBICACION)).sendKeys(Keys.ENTER);
            Thread.sleep(5000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó lugar ubicación : " + lugarUbicacion);
            generateWord.sendText("Se ingresó la ubicación correctamente");
            generateWord.addImageToWord(driver);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se dió click en el boton 'Ubicar Mapa'");
            Sleeper.Sleep(500);

        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Click en el boton Continuar, Lugar Ubicacion$")
    public void clickEnElBotonContinuarLugarUbicacion() throws Exception {
        try {

            Sleeper.Sleep(1500);
            scrollBar();
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se dió click en el boton 'Continuar'");
            generateWord.sendText("Se ingresó la ubicación correctamente");
            generateWord.addImageToWord(driver);
            driver.switchTo().defaultContent();
            WebElement continuardireccion = driver.findElement(By.className("boton_greentdp"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", continuardireccion);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continuardireccion);
            By continuardireccionBtnLocator = By.className("boton_greentdp");
            Sleeper.Sleep(500);

        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @When("^Seleccionar tipo de producto y nombre de producto \"([^\"]*)\"$")
    public void seleccionarTipoDeProductoYNombreDeProducto(String casoDePrueba) throws Throwable {
        try {
            int movistarFija = Integer.parseInt(casoDePrueba) - 1;
            String typeProduct = getData().get(movistarFija).get(COLUMNA_TIPO_PRODUCTO);
            String productName = getData().get(movistarFija).get(COLUMNA_NOMBRE_PRODUCTO);
            switch (typeProduct) {
                case "TRÍO":
                    driver.findElement(By.xpath(TRIO)).click();
                    Sleeper.Sleep(1500);
                    scrollBar();
                    int count3 = 0;
                    List listRow3 = driver.findElements(By.xpath(XPATH_TRIO_ULTRA));
                    for (int i = 0; i < listRow3.size(); i++) {
                        WebElement contestName = (WebElement) listRow3.get(i);
                        String getName = contestName.getText();
                        count3++;
                        if (getName.equalsIgnoreCase(productName)) {
                            driver.findElement(By.xpath("//div[@class='trio_inf acordeon'][" + count3 + "]//a")).click();
                        }
                    }
                    ExtentReportUtil.INSTANCE.stepPass(driver, "Se elegió el Tipo de Producto : " + typeProduct + ", y se eligió el producto : " + productName);
                    generateWord.sendText("Se elegió el Tipo de Producto : " + typeProduct + ", y se eligió el producto : " + productName);
                    generateWord.addImageToWord(driver);
                    break;
                case "DÚO":
                    driver.findElement(By.xpath(DUO)).click();
                    Sleeper.Sleep(1500);
                    scrollBar();
                    int count2 = 0;
                    List listRow2 = driver.findElements(By.xpath(XPATH_DUO_ULTRA));
                    for (int i = 0; i < listRow2.size(); i++) {
                        WebElement contestName = (WebElement) listRow2.get(i);
                        String getName = contestName.getText();
                        count2++;
                        if (getName.equalsIgnoreCase(productName)) {
                            driver.findElement(By.xpath(XPATH_DUO.replace(CAMPO_REEMPLAZAR, Integer.toString(count2)))).click();
                            generateWord.sendText("Se elegió el Tipo de Producto : " + typeProduct + ", y se eligió el producto : " + productName);
                            generateWord.addImageToWord(driver);
                            break;
                        }
                    }
                    ExtentReportUtil.INSTANCE.stepPass(driver, "Se elegió el Tipo de Producto : " + typeProduct + ", y se eligió el producto : " + productName);
                    break;
                case "MONO":
                    driver.findElement(By.xpath(MONO)).click();
                    Sleeper.Sleep(1500);
                    scrollBar();
                    int count = 0;
                    List listRow = driver.findElements(By.xpath(XPATH_MONO_ULTRA));
                    for (int i = 0; i < listRow.size(); i++) {
                        WebElement contestName = (WebElement) listRow.get(i);
                        String getName = contestName.getText();
                        count++;
                        if (getName.equalsIgnoreCase(productName)) {
                            driver.findElement(By.xpath("//div[@class='mono_inf acordeon'][" + count + "]//a")).click();
                        }
                    }
                    ExtentReportUtil.INSTANCE.stepPass(driver, "Se elegió el Tipo de Producto : " + typeProduct + ", y se eligió el producto : " + productName);
                    generateWord.sendText("Se elegió el Tipo de Producto : " + typeProduct + ", y se eligió el producto : " + productName);
                    generateWord.addImageToWord(driver);
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error en  " + e.getMessage());
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Seleccionar SVAS$")
    public void seleccionarSVAS() throws Exception {

        try {

            driver.switchTo().defaultContent();
            Sleeper.Sleep(1500);
            scrollBar();
            ExtentReportUtil.INSTANCE.stepPass(driver, "Click en el boton Continuar");
            generateWord.sendText("Click en el boton Continuar");
            generateWord.addImageToWord(driver);
            driver.findElement(By.xpath(BTN_CONTINUAR_SVAS)).click();

        }
        catch (Exception e){
            System.out.println("Error en  " + e.getMessage());
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);

        }


    }

    @And("^Aceptar condiciones y ingresar email$")
    public void aceptarCondicionesYIngresarEmail() throws Exception {

        try {

            driver.findElement(By.id("email")).clear();
            driver.findElement(By.id("email")).sendKeys("test@test.com");
            Sleeper.Sleep(1500);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Agregar email");
            scrollBar();
            ExtentReportUtil.INSTANCE.stepPass(driver, "Click en el boton Continuar");
            generateWord.sendText("Click en el boton Continuar");
            generateWord.addImageToWord(driver);
            scrollBar();
            Sleeper.Sleep(1500);
            driver.findElement(By.xpath("/html/body/my-app/main/saleprocess/div/div/div/salecondition/div/div/div[2]/div[4]/a")).click();
        }

        catch (Exception e){

            System.out.println("Error en  " + e.getMessage());
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }


    }

    @And("^Confirmar el resumen de la venta y aceptar el speech de grabacion$")
    public void confirmarElResumenDeLaVentaYAceptarElSpeechDeGrabacion() throws Exception {

        try {

            generateWord.sendText("Se muestra el plan a contratar");
            generateWord.addImageToWord(driver);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Click en el boton Continuar");
            scrollBar();
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/my-app/main/saleprocess/div/div/div/salesummary/div[2]/div/div[2]/div[4]/a")).click();
            scrollBar();
            Thread.sleep(3000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Click en el boton Continuar");
            generateWord.sendText("Click en el boton Continuar");
            generateWord.addImageToWord(driver);
            driver.findElement(By.xpath("/html/body/my-app/main/saleprocess/div/div/div/contract/div/div/div[2]/div[4]/div[3]/div/div/div/a")).click();

        }

        catch (Exception e){

            System.out.println("Error en  " + e.getMessage());
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }


    }

    @And("^Ingresar la respuesta de Reniec$")
    public void ingresarLaRespuestaDeReniec() throws Exception {

        try {

            Sleeper.Sleep(1500);
            while (driver.findElements(By.xpath("/html/body/my-app/main/saleprocess/div/div/div/reniec/div[2]/div[1]/div/a[1]")).size()!=0) {
                driver.navigate().refresh();
            }

            Select objDriver = new Select(driver.findElement(By.id("parentescoSelect")));
            objDriver.selectByVisibleText("TEODORA");
            ExtentReportUtil.INSTANCE.stepPass(driver, "Respuesta de Reniec");
            generateWord.sendText("Respuesta de Reniec");
            generateWord.addImageToWord(driver);
            Sleeper.Sleep(1500);
            scrollBar();
            Sleeper.Sleep(1500);
            driver.findElement(By.xpath("/html/body/my-app/main/saleprocess/div/div/div/reniec/div[2]/div/div[2]/div[4]/a")).click();

        }

        catch (Exception e){

            System.out.println("Error en  " + e.getMessage());
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);


        }

    }

    @Then("^ingresar nombre, numero y finalizar venta$")
    public void ingresarNombreNumeroYFinalizarVenta() throws Exception {
        try {

            driver.findElement(By.id("0fullName")).clear();
            driver.findElement(By.id("0fullName")).sendKeys("EDWIN");
            Sleeper.Sleep(1500);
            driver.findElement(By.id("0phoneNumber")).clear();
            driver.findElement(By.id("0phoneNumber")).sendKeys("959678080");
            Sleeper.Sleep(1500);
            scrollBar();
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresar nombre y numero");
            generateWord.sendText("Ingresar nombre y numero");
            generateWord.addImageToWord(driver);
            driver.findElement(By.xpath("/html/body/my-app/main/contactoinstalacion/div/div/div[2]/app-form-contacto/div/div[1]/a")).click();
            Thread.sleep(5000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Venta finalizada");
            generateWord.sendText("Venta finalizada");
            generateWord.addImageToWord(driver);
            Sleeper.Sleep(1500);

        }
        catch (Exception e){

            System.out.println("Error en  " + e.getMessage());
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);

        }
    }


    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, LOGIN_WEB);
    }

    protected void scrollBar() {
        JavascriptExecutor ev = (JavascriptExecutor) driver;
        ev.executeScript("window.scrollBy(0, 720)");
    }



}
