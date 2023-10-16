package com.example.mytask.core.utils

object Constants {
    const val USERS_TABLE_NAME="users"

    //json response keys
    const val proplem="problems"
    const val diabetes="Diabetes"
    const val asthma="Asthma"
    const val medications="medications"
    const val labs="labs"
    const val missing_field="missing_field"
    const val medicationsClasses="medicationsClasses"
    fun className(index:Int):String{
        return if (index>1)"className" else "className${index+1}"
    }
    fun associatedDrug(index:Int):String{
        return if (index>1)"associatedDrug" else "associatedDrug#${index+1}"
    }
    const val nameMed="name"
    const val dose="dose"
    const val strength="strength"

    const val myJson = """{
  "problems": [
    {
      "Diabetes": [
        {
          "medications": [
            {
              "medicationsClasses": [
                {
                  "className": [
                    {
                      "associatedDrug": [
                        {
                          "name": "asprin",
                          "dose": "",
                          "strength": "500 mg"
                        }
                      ],
                      "associatedDrug#2": [
                        {
                          "name": "somethingElse",
                          "dose": "",
                          "strength": "500 mg"
                        }
                      ]
                    }
                  ],
                  "className2": [
                    {
                      "associatedDrug": [
                        {
                          "name": "asprin",
                          "dose": "",
                          "strength": "500 mg"
                        }
                      ],
                      "associatedDrug#2": [
                        {
                          "name": "somethingElse",
                          "dose": "",
                          "strength": "500 mg"
                        }
                      ]
                    }
                  ]
                }
              ]
            }
          ],
          "labs": [
            {
              "missing_field": "missing_value"
            }
          ]
        }
      ],
      "Asthma": [
        {}
      ]
    }
  ]
}"""

}




