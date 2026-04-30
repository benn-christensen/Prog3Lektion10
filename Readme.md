# Opgave 1: Adapter Mønsteret (Adapter Pattern)

I denne opgave skal du implementere **Adapter mønsteret** for at få to inkompatible systemer til at arbejde sammen.

## Scenarie
Du har et system, der forventer at læse temperaturer via `TemperatureSensor` interfacet, som returnerer grader i **Celsius**.
Du har dog fået en ny sensor, `FahrenheitSensor`, som kun kan returnere grader i **Fahrenheit**.

Din opgave er at skabe en "bro" mellem disse to ved at implementere en `FahrenheitSensorAdapter`.

1. Opret og implementer `FahrenheitAdapter.java`:
   - Formel for konvertering: `Celsius = (Fahrenheit - 32) * 5 / 9`.
2. Afprøv din løsning i `Main.java`.

## Forventet output
Hvis du tester med 100 grader Fahrenheit, bør resultatet være ca. 37.78 grader Celsius.
