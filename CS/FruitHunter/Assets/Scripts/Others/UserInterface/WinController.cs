using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class WinController : MonoBehaviour
{
    public Text rank;
    public Text resultTime;
    public Text levelName;
    public GameObject fruits;
    float totalTime;

    void Start() 
    {
        levelName.text = SceneManager.GetActiveScene().name + " completado";
        totalTime = fruits.GetComponent<FruitManager>().infoTime();
        guessRank();
        resultTime.text = "Tiempo : " + totalTime.ToString("F2");
    }


    void guessRank()
    {
        if(totalTime <= 30)
        {
            rank.fontSize = 90;
            rank.color = Color.yellow;
            rank.text = "S";
        }
            else if (30 < totalTime && totalTime <= 40)
            {
                rank.fontSize = 75;
                rank.color = Color.cyan;
                rank.text = "A";
            }
                else if (40 < totalTime && totalTime <= 50)
                {
                    rank.fontSize = 60;
                    rank.color = Color.green;
                    rank.text = "B";
                }
                    else if (50 < totalTime && totalTime <= 60)
                    {
                        rank.fontSize = 40;
                        rank.color = Color.gray;
                        rank.text = "C";
                    }
                        else if (60 < totalTime)
                        {
                            rank.fontSize = 28;
                            rank.color = Color.red;
                            rank.text = "D";
                        }

    }

}