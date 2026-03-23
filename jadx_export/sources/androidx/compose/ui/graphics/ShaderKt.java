package androidx.compose.ui.graphics;

import android.graphics.Shader;
import java.util.List;
import kotlin.Metadata;

/* compiled from: Shader.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\u001a0\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001aN\u0010\n\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001aN\u0010\u0016\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a<\u0010\u001b\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0017\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"ImageShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "tileModeX", "Landroidx/compose/ui/graphics/TileMode;", "tileModeY", "ImageShader-F49vj9s", "(Landroidx/compose/ui/graphics/ImageBitmap;II)Landroid/graphics/Shader;", "LinearGradientShader", "from", "Landroidx/compose/ui/geometry/Offset;", "to", "colors", "", "Landroidx/compose/ui/graphics/Color;", "colorStops", "", "tileMode", "LinearGradientShader-VjE6UOU", "(JJLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "RadialGradientShader", "center", "radius", "RadialGradientShader-8uybcMk", "(JFLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "SweepGradientShader", "SweepGradientShader-9KIMszo", "(JLjava/util/List;Ljava/util/List;)Landroid/graphics/Shader;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ShaderKt {
    /* renamed from: LinearGradientShader-VjE6UOU$default, reason: not valid java name */
    public static /* synthetic */ Shader m4510LinearGradientShaderVjE6UOU$default(long j, long j2, List list, List list2, int i, int i2, Object obj) {
        List list3;
        int iM4567getClamp3opZhB0;
        if ((i2 & 8) == 0) {
            list3 = list2;
        } else {
            list3 = null;
        }
        if ((i2 & 16) == 0) {
            iM4567getClamp3opZhB0 = i;
        } else {
            iM4567getClamp3opZhB0 = TileMode.INSTANCE.m4567getClamp3opZhB0();
        }
        return m4509LinearGradientShaderVjE6UOU(j, j2, list, list3, iM4567getClamp3opZhB0);
    }

    /* renamed from: LinearGradientShader-VjE6UOU, reason: not valid java name */
    public static final Shader m4509LinearGradientShaderVjE6UOU(long from, long to, List<Color> list, List<Float> list2, int tileMode) {
        return AndroidShader_androidKt.m4088ActualLinearGradientShaderVjE6UOU(from, to, list, list2, tileMode);
    }

    /* renamed from: RadialGradientShader-8uybcMk$default, reason: not valid java name */
    public static /* synthetic */ Shader m4512RadialGradientShader8uybcMk$default(long j, float f, List list, List list2, int i, int i2, Object obj) {
        List list3;
        int iM4567getClamp3opZhB0;
        if ((i2 & 8) == 0) {
            list3 = list2;
        } else {
            list3 = null;
        }
        if ((i2 & 16) == 0) {
            iM4567getClamp3opZhB0 = i;
        } else {
            iM4567getClamp3opZhB0 = TileMode.INSTANCE.m4567getClamp3opZhB0();
        }
        return m4511RadialGradientShader8uybcMk(j, f, list, list3, iM4567getClamp3opZhB0);
    }

    /* renamed from: RadialGradientShader-8uybcMk, reason: not valid java name */
    public static final Shader m4511RadialGradientShader8uybcMk(long center, float radius, List<Color> list, List<Float> list2, int tileMode) {
        return AndroidShader_androidKt.m4089ActualRadialGradientShader8uybcMk(center, radius, list, list2, tileMode);
    }

    /* renamed from: SweepGradientShader-9KIMszo$default, reason: not valid java name */
    public static /* synthetic */ Shader m4514SweepGradientShader9KIMszo$default(long j, List list, List list2, int i, Object obj) {
        if ((i & 4) != 0) {
            list2 = null;
        }
        return m4513SweepGradientShader9KIMszo(j, list, list2);
    }

    /* renamed from: SweepGradientShader-9KIMszo, reason: not valid java name */
    public static final Shader m4513SweepGradientShader9KIMszo(long center, List<Color> list, List<Float> list2) {
        return AndroidShader_androidKt.m4090ActualSweepGradientShader9KIMszo(center, list, list2);
    }

    /* renamed from: ImageShader-F49vj9s$default, reason: not valid java name */
    public static /* synthetic */ Shader m4508ImageShaderF49vj9s$default(ImageBitmap imageBitmap, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = TileMode.INSTANCE.m4567getClamp3opZhB0();
        }
        if ((i3 & 4) != 0) {
            i2 = TileMode.INSTANCE.m4567getClamp3opZhB0();
        }
        return m4507ImageShaderF49vj9s(imageBitmap, i, i2);
    }

    /* renamed from: ImageShader-F49vj9s, reason: not valid java name */
    public static final Shader m4507ImageShaderF49vj9s(ImageBitmap image, int tileModeX, int tileModeY) {
        return AndroidShader_androidKt.m4087ActualImageShaderF49vj9s(image, tileModeX, tileModeY);
    }
}
