package com.example.repararapido.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.repararapido.Model.Solicitud;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {

    private static final String DB_NAME = "ReparaRapidoDB.db";
    private static final int DB_VER=1;
    public Database(Context context){
        super(context,DB_NAME,null,DB_VER);
    }

    public List<Solicitud> getSolicitudes()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"EmpleadoNombre","EmpleadoCategoria"};
        String sqlTable = "Solicitudes";

        qb.setTables(sqlTable);

        Cursor c = qb.query(db,sqlSelect,null,null,null,null,null);
        final List<Solicitud> result = new ArrayList<>();
        if(c.moveToFirst())
        {
            do{
                result.add(new Solicitud(c.getString(c.getColumnIndex("EmpleadoId")),
                        c.getString(c.getColumnIndex("EmpleadoNombre")),
                        c.getString(c.getColumnIndex("EmpleadoCategoria"))
                ));
            } while (c.moveToNext());
        }
        return result;
    }

    public void addToSolicitudes(Solicitud solicitud)
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("INSERT INTO Solicitudes(EmpleadoID,EmpleadoNombre,EmpleadoCategoria) VALUES ('%s','%s','%s');",
                solicitud.getEmpleadoID(),
                solicitud.getEmpleadoNombre(),
                solicitud.getEmpleadoCategoria());
        db.execSQL(query);
    }

    public void cleanSolicitud()
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("DELETE FROM Solicitudes");
        db.execSQL(query);
    }
}
