# Imagen base de Python
FROM python:3.10

# Crear directorio en el contenedor
WORKDIR /app

# Copiar archivos al contenedor
COPY requirements.txt requirements.txt
RUN pip install -r requirements.txt

COPY . .

# Exponer el puerto
EXPOSE 5000

# Comando para iniciar la app
CMD ["python", "app.py"]
