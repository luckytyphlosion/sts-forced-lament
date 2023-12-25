package forcedlament.patches;

import java.lang.reflect.Field;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.neow.NeowEvent;

@SpirePatch(
    clz = NeowEvent.class,
    method = SpirePatch.CONSTRUCTOR,
    paramtypez = {
        boolean.class
    }
)
public class NeowEventPatch
{
    /*@SpirePostfixPatch
    public static void forceMiniBlessing_noParams(NeowEvent _instance)
    {
        
    }*/

    @SpirePostfixPatch
    public static void forceMiniBlessing(NeowEvent _instance, boolean isDone)
    {
        try {
            Field bossCountField = _instance.getClass().getDeclaredField("bossCount");
            bossCountField.setAccessible(true);
            bossCountField.setInt(_instance, 0);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
