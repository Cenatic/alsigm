script:
{

    // Recorrer el arbol de nodos para obtener el tama�o de la carpeta y el n�mero de ficheros
    function inspectFolder(folder) {
        var children = folder.children;
        for (var i = 0; i < children.length; i++) {
            if (children[i].isDocument) {
                folderFiles++;
                folderSize += children[i].size;
            } else if (children[i].isContainer) {
                inspectFolder(children[i]);
            }
        }
    }
    
    // locate folder by  path
    var folder = companyhome.childByNamePath(url.extension);
    if (folder == undefined || !folder.isContainer) {
       status.code = 404;
       status.message = "Folder " + url.extension + " not found.";
       status.redirect = true;
    }
    
    model.folder = folder;
    
    var folderSize = 0;
    var folderFiles = 0;

    inspectFolder(folder);

    // Convertir a cadena para que la vista no formatee los numeros
    model.folderSize = "" + folderSize;
    model.folderFiles = "" + folderFiles;
    
}