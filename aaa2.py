import PyPDF2
from PyPDF2 import PdfReader, PdfWriter
import os

def buscar_y_guardar_pagina(pdf_path, nombre, output_pdf_path):
    try:
        with open(pdf_path, 'rb') as pdf_file:
            pdf_reader = PdfReader(pdf_file)
            pdf_writer = PdfWriter()
            paginas_encontradas = False

            # Recorre todas las páginas del PDF
            for page_num, page in enumerate(pdf_reader.pages):
                text = page.extract_text()
               
                # Busca el nombre en el texto de la página
                if text and nombre in text:
                    print(f'Nombre "{nombre}" encontrado en la página {page_num + 1}')
                    pdf_writer.add_page(page)
                    paginas_encontradas = True

            # Guarda solo si se encontró alguna página
            if paginas_encontradas:
                with open(output_pdf_path, 'wb') as output_pdf_file:
                    pdf_writer.write(output_pdf_file)
                print(f'Páginas guardadas en: {output_pdf_path}')
            else:
                print(f'El nombre "{nombre}" no se encontró en el PDF.')

    except Exception as e:
        print(f"Error: {e}")

# Función para mostrar el menú
def mostrar_menu():
    while True:
        print("\n=== Menú de búsqueda en PDF ===")
       
        # Solicitar la ruta del archivo PDF
        pdf_path = input("Introduce la ruta del archivo PDF: ")
       
        # Verificar si el archivo existe
        if not os.path.exists(pdf_path):
            print(f"El archivo {pdf_path} no existe.")
            continue
       
        # Solicitar el nombre a buscar
        nombre = input("Introduce el nombre a buscar: ")
       
        # Solicitar la ruta para guardar el archivo resultante
        output_pdf_path = input("Introduce la ruta para guardar la página encontrada (por ejemplo, 'salida.pdf'): ")

        # Llamar a la función para buscar el nombre y guardar la página
        buscar_y_guardar_pagina(pdf_path, nombre, output_pdf_path)

        # Preguntar si el usuario quiere realizar otra búsqueda
        otra_busqueda = input("¿Quieres realizar otra búsqueda? (sí/no): ").strip().lower()
        if otra_busqueda != 's':
            print("Saliendo del programa.")
            break

# Iniciar el script
if __name__ == "__main__":
    mostrar_menu()
