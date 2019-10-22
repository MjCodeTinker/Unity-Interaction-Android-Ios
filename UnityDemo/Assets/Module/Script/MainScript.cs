using UnityEngine;
using UnityEngine.UI;

public class MainScript : MonoBehaviour
{
    public Text _text;
    private void Start()
    {
        AndroidPlatform.Instance.GetAndoridInfo(delegate(AndroidBaseEntity entity) { _text.text = entity.androidId; });
    }
}