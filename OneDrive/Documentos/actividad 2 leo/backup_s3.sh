#!/bin/bash

BUCKET_NAME="actividad2-leo"
BACKUP_FILE="backup_$(date +%Y%m%d).tar.gz"
LOG_FILE="/tmp/backup_s3.log"

echo "Iniciano Respaldo..." >> $LOG_FILE
tar -czf $BACKUP_FILE "C:/Users/Leo_1/OneDrive/Documentos/carpeta prueba act2" >> $LOG_FILE 2>&1

if aws s3 cp $BACKUP_FILE s3://$BUCKET_NAME/ >> $LOG_FILE 2>&1; then
    echo "Respaldo subido exitosamnte:" >> $LOG_FILE
else
    echo "Error al subir el respaldo a S3:" >> $LOG_FILE
fi