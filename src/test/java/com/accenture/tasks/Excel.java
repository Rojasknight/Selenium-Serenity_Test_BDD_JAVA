package com.accenture.tasks;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jruby.ir.operands.Array;
 
public class Excel {
 
	
	static String nombreArchivo = "ActvidadCorreosMasivos.xlsx";
	static String rutaArchivo = "C:\\Users\\danny.rojas\\Desktop\\Retos\\2 - ScreenPlaySerenity\\" + nombreArchivo;
	String hoja = "Hoja1";
		
		
		public static ArrayList<Dato> lectura(){
			ArrayList<Dato> datos = new ArrayList<>();
 
		try  {
			FileInputStream file = new FileInputStream(new File(rutaArchivo));
			// leer archivo excel
			XSSFWorkbook worbook = new XSSFWorkbook(file);
			//obtener la hoja que se va leer
			XSSFSheet sheet = worbook.getSheetAt(0);
			//obtener todas las filas de la hoja excel
			Iterator<Row> rowIterator = sheet.iterator();
 
			Row row;
			
			Dato info =null;
			// se recorre cada fila hasta el final
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				//se obtiene las celdas por fila
				Iterator<Cell> cellIterator = row.cellIterator();
				Cell cell;
				int count=0;
				info =  new Dato();
				
				//se recorre cada celda
				while (cellIterator.hasNext()) {
					cell = cellIterator.next();
					switch(count) {
					case 0:
						info.setCorreo(cell.getStringCellValue());
						System.out.println("--" + info.getCorreo());
						
						break;
					case 1:
						info.setAsunto(cell.getStringCellValue());
						break;
					case 2:
						info.setTexto(cell.getStringCellValue());
						 break;
					}
					count++;
					
					
					// se obtiene la celda en específico y se la imprimir
				}
				System.out.println();
				datos.add(info);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return datos;
	}
	}

