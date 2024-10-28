import PyPDF2
import pdfplumber
def buscar_nombre_y_guardar_pagina_pdf(ruta_pdf, nombre_a_buscar):
try:
# Abrir el archivo PDF con pdfplumber para buscar el texto
with pdfplumber.open(ruta_pdf) as pdf:
for numero_pagina, pagina in enumerate(pdf.pages):
texto_pagina = pagina.extract_text()
# Verificar si el nombre está en el texto de la página
if nombre_a_buscar in texto_pagina:
print(f&quot;Nombre &#39;{nombre_a_buscar}&#39; encontrado en la página {numero_pagina +
1}&quot;)
# Ahora extraemos esa página y la guardamos en un nuevo archivo PDF
usando PyPDF2
with open(ruta_pdf, &#39;rb&#39;) as archivo_pdf:
lector_pdf = PyPDF2.PdfReader(archivo_pdf)
escritor_pdf = PyPDF2.PdfWriter()
# Agregar la página encontrada al nuevo PDF
pagina_encontrada = lector_pdf.pages[numero_pagina]
escritor_pdf.add_page(pagina_encontrada)
# Guardar la nueva página en un archivo PDF
nuevo_pdf = f&quot;resultado_pagina_{numero_pagina + 1}.pdf&quot;
with open(nuevo_pdf, &#39;wb&#39;) as archivo_salida:
escritor_pdf.write(archivo_salida)
print(f&quot;Página guardada como &#39;{nuevo_pdf}&#39;&quot;)
return
print(f&quot;El nombre &#39;{nombre_a_buscar}&#39; no fue encontrado en el PDF.&quot;)
except Exception as e:
print(f&quot;Ha ocurrido un error: {e}&quot;)
# Función para mostrar el menú e interactuar con el usuario
def menu():
print(&quot;===== MENÚ DE BÚSQUEDA EN PDF =====&quot;)
ruta_pdf = input(&quot;Introduce la ruta del archivo PDF: &quot;)
nombre_a_buscar = input(&quot;Introduce el nombre que deseas buscar: &quot;)
# Llamamos a la función para buscar el nombre y guardar la página
buscar_nombre_y_guardar_pagina_pdf(ruta_pdf, nombre_a_buscar)
# Ejecutar el menú

if __name__ == &quot;__main__&quot;:
menu()

# Explicación del código:
# ● Función menu(): Esta función es el menú interactivo donde el usuario ingresa la
# ruta del archivo PDF y el nombre que desea buscar. Luego, estos datos se pasan a
# la función buscar_nombre_y_guardar_pagina_pdf() para que realice la búsqueda y el
# guardado de la página.
# ● Captura de entrada del usuario:
# ● input() se utiliza para que el usuario introduzca la ruta del PDF y el nombre a buscar.
# ● Después de obtener esos valores, se llama a la función principal de búsqueda.
# ● Condicional if __name__ == &quot;__main__&quot;:: Esto asegura que el menú se ejecute
# solo si el script es ejecutado directamente (y no si es importado desde otro script).
# Cómo usarlo:
# ● Ejecutar el código:
# ● Guarda este código en un archivo Python, por ejemplo, busqueda_pdf.py.
# ● Ejecútalo desde tu terminal o entorno de desarrollo (como Visual Studio Code o
# PyCharm).
# ● Interacción del usuario:
# ● El programa mostrará un menú en la consola donde el usuario podrá ingresar:
# ● La ruta completa del archivo PDF (por ejemplo, C:/documentos/archivo.pdf).
# ● El nombre que desea buscar en el PDF (por ejemplo, John Doe).
# ● Resultado:
# ● El programa buscará el nombre dentro del archivo PDF.
# ● Si lo encuentra, guardará la página como un nuevo archivo PDF en el directorio de
# trabajo actual.

# Ejemplo de salida:
# css
# Copiar código

# ===== MENÚ DE BÚSQUEDA EN PDF =====
# Introduce la ruta del archivo PDF: C:/documentos/archivo.pdf
# Introduce el nombre que deseas buscar: John Doe
# Nombre &#39;John Doe&#39; encontrado en la página 5
# Página guardada como &#39;resultado_pagina_5.pdf&#39;
