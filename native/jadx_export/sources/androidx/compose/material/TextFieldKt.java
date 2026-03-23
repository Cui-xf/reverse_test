package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;

/* compiled from: TextField.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0087\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010,\u001a\u0093\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010-\u001a\u00020%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010.\u001a\u0087\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020/2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00100\u001a\u0093\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020/2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010-\u001a\u00020%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00101\u001a\u009a\u0001\u00102\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\n0\u0017¢\u0006\u0002\b\u00182\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0019\u0010\u0019\u001a\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e¢\u0006\u0002\b\u00182\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0013\u00105\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0006\u0010#\u001a\u00020\u00122\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\u0010:\u001aZ\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001aB\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020%2\u0006\u0010K\u001a\u00020%2\u0006\u0010L\u001a\u00020%2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a\u0014\u0010O\u001a\u00020\u0010*\u00020\u00102\u0006\u0010P\u001a\u00020QH\u0000\u001at\u0010R\u001a\u00020\n*\u00020S2\u0006\u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020%2\u0006\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010W2\b\u0010Y\u001a\u0004\u0018\u00010W2\b\u0010Z\u001a\u0004\u0018\u00010W2\b\u0010[\u001a\u0004\u0018\u00010W2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010\\\u001a\u00020%2\u0006\u0010]\u001a\u00020%2\u0006\u00106\u001a\u0002072\u0006\u0010D\u001a\u000207H\u0002\u001aZ\u0010^\u001a\u00020\n*\u00020S2\u0006\u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020%2\u0006\u0010_\u001a\u00020W2\b\u0010Y\u001a\u0004\u0018\u00010W2\b\u0010Z\u001a\u0004\u0018\u00010W2\b\u0010[\u001a\u0004\u0018\u00010W2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010D\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002\u001a\u0014\u0010`\u001a\u00020%*\u00020%2\u0006\u0010a\u001a\u00020%H\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006b"}, d2 = {"FirstBaselineOffset", "Landroidx/compose/ui/unit/Dp;", "getFirstBaselineOffset", "()F", "F", "TextFieldBottomPadding", "getTextFieldBottomPadding", "TextFieldTopPadding", "getTextFieldTopPadding", "TextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "calculateHeight", "textFieldHeight", "hasLabel", "labelBaseline", "leadingHeight", "trailingHeight", "placeholderHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-O3s9Psw", "(IZIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingWidth", "trailingWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-VsPV1Ek", "(IIIIIJ)I", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/foundation/BorderStroke;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "height", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "substractConstraintSafely", "from", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldKt {
    private static final float FirstBaselineOffset = Dp.m6693constructorimpl(20);
    private static final float TextFieldBottomPadding = Dp.m6693constructorimpl(10);
    private static final float TextFieldTopPadding = Dp.m6693constructorimpl(2);

    public static final void TextField(final String value, final Function1<? super String, Unit> function1, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean enabled2;
        boolean readOnly2;
        TextStyle textStyle2;
        Function2 function25;
        Function2 function26;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        TextFieldColors textFieldColors;
        int $dirty1;
        int i8;
        int $dirty;
        TextStyle textStyle3;
        Function2 label;
        Function2 placeholder;
        Function2 leadingIcon;
        Function2 trailingIcon;
        boolean isError2;
        VisualTransformation visualTransformation2;
        int $dirty12;
        KeyboardActions keyboardActions2;
        int maxLines2;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        int $dirty13;
        Composer $composer2;
        TextFieldColors colors2;
        KeyboardActions keyboardActions3;
        TextStyle textStyle4;
        int $dirty2;
        KeyboardOptions keyboardOptions2;
        boolean singleLine2;
        int maxLines3;
        int minLines2;
        int $dirty3;
        int $dirty14;
        MutableInteractionSource interactionSource3;
        Composer $composer3;
        final boolean singleLine3;
        final VisualTransformation visualTransformation3;
        final TextStyle textStyle5;
        final Modifier modifier3;
        final TextFieldColors colors3;
        final boolean enabled3;
        final boolean readOnly3;
        final int maxLines4;
        final int minLines3;
        final Function2 label2;
        final Function2 placeholder2;
        final Function2 leadingIcon2;
        final MutableInteractionSource interactionSource4;
        final Shape shape3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions4;
        final Function2 trailingIcon2;
        final boolean isError3;
        Object value$iv;
        int $dirty15;
        Composer $composer4 = $composer.startRestartGroup(-1504264404);
        ComposerKt.sourceInformation($composer4, "C(TextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)165@8582L7,178@9226L14,179@9290L17,194@9914L38,203@10281L20,211@10623L719,190@9731L1617:TextField.kt#jmzs0o");
        int $dirty4 = $changed;
        int $dirty16 = $changed1;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty4 |= $composer4.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty4 |= $composer4.changedInstance(function1) ? 32 : 16;
        }
        int i9 = i & 4;
        if (i9 != 0) {
            $dirty4 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer4.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i10 = i & 8;
        if (i10 != 0) {
            $dirty4 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty4 |= $composer4.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i11 = i & 16;
        if (i11 != 0) {
            $dirty4 |= 24576;
            readOnly2 = readOnly;
        } else if (($changed & 24576) == 0) {
            readOnly2 = readOnly;
            $dirty4 |= $composer4.changed(readOnly2) ? 16384 : 8192;
        } else {
            readOnly2 = readOnly;
        }
        if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if ((i & 32) == 0) {
                textStyle2 = textStyle;
                int i12 = $composer4.changed(textStyle2) ? 131072 : 65536;
                $dirty4 |= i12;
            } else {
                textStyle2 = textStyle;
            }
            $dirty4 |= i12;
        } else {
            textStyle2 = textStyle;
        }
        int i13 = i & 64;
        if (i13 != 0) {
            $dirty4 |= 1572864;
            function25 = function2;
        } else if (($changed & 1572864) == 0) {
            function25 = function2;
            $dirty4 |= $composer4.changedInstance(function25) ? 1048576 : 524288;
        } else {
            function25 = function2;
        }
        int i14 = i & 128;
        if (i14 != 0) {
            $dirty4 |= 12582912;
            function26 = function22;
        } else if (($changed & 12582912) == 0) {
            function26 = function22;
            $dirty4 |= $composer4.changedInstance(function26) ? 8388608 : 4194304;
        } else {
            function26 = function22;
        }
        int i15 = i & 256;
        if (i15 != 0) {
            $dirty4 |= 100663296;
            i2 = i15;
        } else if (($changed & 100663296) == 0) {
            i2 = i15;
            $dirty4 |= $composer4.changedInstance(function23) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i15;
        }
        int i16 = i & 512;
        if (i16 != 0) {
            $dirty4 |= 805306368;
            i3 = i16;
        } else if (($changed & 805306368) == 0) {
            i3 = i16;
            $dirty4 |= $composer4.changedInstance(function24) ? 536870912 : 268435456;
        } else {
            i3 = i16;
        }
        int i17 = i & 1024;
        if (i17 != 0) {
            $dirty16 |= 6;
            i4 = i17;
        } else if (($changed1 & 6) == 0) {
            i4 = i17;
            $dirty16 |= $composer4.changed(isError) ? 4 : 2;
        } else {
            i4 = i17;
        }
        int i18 = i & 2048;
        if (i18 != 0) {
            $dirty16 |= 48;
            i5 = i18;
        } else if (($changed1 & 48) == 0) {
            i5 = i18;
            $dirty16 |= $composer4.changed(visualTransformation) ? 32 : 16;
        } else {
            i5 = i18;
        }
        int i19 = i & 4096;
        if (i19 != 0) {
            $dirty16 |= 384;
            i6 = i19;
        } else {
            i6 = i19;
            if (($changed1 & 384) == 0) {
                $dirty16 |= $composer4.changed(keyboardOptions) ? 256 : 128;
            }
        }
        if (($changed1 & 3072) == 0) {
            $dirty16 |= ((i & 8192) == 0 && $composer4.changed(keyboardActions)) ? 2048 : 1024;
        }
        int i20 = i & 16384;
        if (i20 != 0) {
            $dirty16 |= 24576;
            i7 = i20;
        } else {
            i7 = i20;
            if (($changed1 & 24576) == 0) {
                $dirty16 |= $composer4.changed(singleLine) ? 16384 : 8192;
            }
        }
        if (($changed1 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            $dirty16 |= ((i & 32768) == 0 && $composer4.changed(maxLines)) ? 131072 : 65536;
        }
        int i21 = i & 65536;
        if (i21 != 0) {
            $dirty16 |= 1572864;
        } else if (($changed1 & 1572864) == 0) {
            $dirty16 |= $composer4.changed(minLines) ? 1048576 : 524288;
        }
        int i22 = i & 131072;
        if (i22 != 0) {
            $dirty16 |= 12582912;
        } else if (($changed1 & 12582912) == 0) {
            $dirty16 |= $composer4.changed(interactionSource) ? 8388608 : 4194304;
        }
        if (($changed1 & 100663296) == 0) {
            $dirty16 |= ((i & 262144) == 0 && $composer4.changed(shape)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed1 & 805306368) == 0) {
            if ((i & 524288) == 0) {
                $dirty15 = $dirty16;
                textFieldColors = colors;
                int i23 = $composer4.changed(textFieldColors) ? 536870912 : 268435456;
                $dirty1 = $dirty15 | i23;
            } else {
                $dirty15 = $dirty16;
                textFieldColors = colors;
            }
            $dirty1 = $dirty15 | i23;
        } else {
            int $dirty17 = $dirty16;
            textFieldColors = colors;
            $dirty1 = $dirty17;
        }
        int $dirty5 = $dirty4;
        if (($dirty4 & 306783379) == 306783378 && (306783379 & $dirty1) == 306783378 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            leadingIcon2 = function23;
            visualTransformation3 = visualTransformation;
            keyboardOptions3 = keyboardOptions;
            maxLines4 = maxLines;
            minLines3 = minLines;
            interactionSource4 = interactionSource;
            shape3 = shape;
            $composer3 = $composer4;
            colors3 = textFieldColors;
            enabled3 = enabled2;
            readOnly3 = readOnly2;
            textStyle5 = textStyle2;
            label2 = function25;
            placeholder2 = function26;
            modifier3 = modifier2;
            trailingIcon2 = function24;
            isError3 = isError;
            keyboardActions4 = keyboardActions;
            singleLine3 = singleLine;
        } else {
            $composer4.startDefaults();
            if (($changed & 1) == 0 || $composer4.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i9 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i10 != 0 ? true : enabled2;
                boolean readOnly4 = i11 != 0 ? false : readOnly2;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    i8 = -458753;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer4.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    textStyle3 = (TextStyle) objConsume;
                    $dirty = $dirty5 & (-458753);
                } else {
                    i8 = -458753;
                    $dirty = $dirty5;
                    textStyle3 = textStyle2;
                }
                label = i13 != 0 ? null : function25;
                placeholder = i14 != 0 ? null : function26;
                leadingIcon = i2 != 0 ? null : function23;
                trailingIcon = i3 != 0 ? null : function24;
                isError2 = i4 != 0 ? false : isError;
                visualTransformation2 = i5 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions4 = i6 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                if ((i & 8192) != 0) {
                    $dirty12 = $dirty1 & (-7169);
                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                } else {
                    $dirty12 = $dirty1;
                    keyboardActions2 = keyboardActions;
                }
                boolean singleLine4 = i7 != 0 ? false : singleLine;
                if ((32768 & i) != 0) {
                    $dirty12 &= i8;
                    maxLines2 = singleLine4 ? 1 : Integer.MAX_VALUE;
                } else {
                    maxLines2 = maxLines;
                }
                int minLines4 = i21 != 0 ? 1 : minLines;
                interactionSource2 = i22 != 0 ? null : interactionSource;
                if ((262144 & i) != 0) {
                    shape2 = TextFieldDefaults.INSTANCE.getTextFieldShape($composer4, 6);
                    $dirty13 = $dirty12 & (-234881025);
                } else {
                    shape2 = shape;
                    $dirty13 = $dirty12;
                }
                if ((i & 524288) != 0) {
                    colors2 = TextFieldDefaults.INSTANCE.m1722textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer4, 0, 0, 48, 2097151);
                    $composer2 = $composer4;
                    keyboardActions3 = keyboardActions2;
                    modifier2 = modifier4;
                    $dirty3 = $dirty13 & (-1879048193);
                    enabled2 = enabled4;
                    readOnly2 = readOnly4;
                    textStyle4 = textStyle3;
                    $dirty2 = $dirty;
                    keyboardOptions2 = keyboardOptions4;
                    singleLine2 = singleLine4;
                    maxLines3 = maxLines2;
                    minLines2 = minLines4;
                } else {
                    $composer2 = $composer4;
                    colors2 = colors;
                    keyboardActions3 = keyboardActions2;
                    modifier2 = modifier4;
                    enabled2 = enabled4;
                    readOnly2 = readOnly4;
                    textStyle4 = textStyle3;
                    $dirty2 = $dirty;
                    keyboardOptions2 = keyboardOptions4;
                    singleLine2 = singleLine4;
                    maxLines3 = maxLines2;
                    minLines2 = minLines4;
                    $dirty3 = $dirty13;
                }
            } else {
                $composer4.skipToGroupEnd();
                int $dirty6 = (i & 32) != 0 ? $dirty5 & (-458753) : $dirty5;
                if ((i & 8192) != 0) {
                    $dirty1 &= -7169;
                }
                if ((32768 & i) != 0) {
                    $dirty1 &= -458753;
                }
                if ((262144 & i) != 0) {
                    $dirty1 &= -234881025;
                }
                if ((i & 524288) != 0) {
                    $dirty1 &= -1879048193;
                }
                leadingIcon = function23;
                trailingIcon = function24;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
                singleLine2 = singleLine;
                maxLines3 = maxLines;
                interactionSource2 = interactionSource;
                shape2 = shape;
                colors2 = colors;
                $dirty2 = $dirty6;
                $composer2 = $composer4;
                label = function25;
                placeholder = function26;
                keyboardActions3 = keyboardActions;
                minLines2 = minLines;
                $dirty3 = $dirty1;
                textStyle4 = textStyle2;
                keyboardOptions2 = keyboardOptions;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1504264404, $dirty2, $dirty3, "androidx.compose.material.TextField (TextField.kt:180)");
            }
            if (interactionSource2 == null) {
                $composer2.startReplaceGroup(-1675073900);
                ComposerKt.sourceInformation($composer2, "182@9393L39");
                ComposerKt.sourceInformationMarkerStart($composer2, -54034642, "CC(remember):TextField.kt#9igjgp");
                Composer $this$cache$iv = $composer2;
                $dirty14 = $dirty3;
                Object it$iv = $this$cache$iv.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = InteractionSourceKt.MutableInteractionSource();
                    $this$cache$iv.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                interactionSource3 = (MutableInteractionSource) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            } else {
                $dirty14 = $dirty3;
                $composer2.startReplaceGroup(-54035293);
                $composer2.endReplaceGroup();
                interactionSource3 = interactionSource2;
            }
            $composer2.startReplaceGroup(-54029535);
            ComposerKt.sourceInformation($composer2, "*185@9580L18");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle4.m6176getColor0d7_KjU();
            if (!($this$takeOrElse_u2dDxMtmZc$iv != 16)) {
                $this$takeOrElse_u2dDxMtmZc$iv = colors2.textColor(enabled2, $composer2, (($dirty2 >> 9) & 14) | (($dirty14 >> 24) & 112)).getValue().m4197unboximpl();
            }
            $composer2.endReplaceGroup();
            long textColor = $this$takeOrElse_u2dDxMtmZc$iv;
            TextStyle mergedTextStyle = textStyle4.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            final boolean enabled5 = enabled2;
            Modifier modifier5 = modifier2;
            final boolean isError4 = isError2;
            TextStyle textStyle6 = textStyle4;
            final MutableInteractionSource interactionSource5 = interactionSource3;
            Modifier modifierM710defaultMinSizeVpY3zN4 = SizeKt.m710defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m1710indicatorLinegv0btCI$default(TextFieldDefaults.INSTANCE, modifier5, enabled5, isError4, interactionSource3, colors2, 0.0f, 0.0f, 48, null), isError4, Strings_androidKt.m1675getString4foXLRw(Strings.INSTANCE.m1670getDefaultErrorMessageUdPEhr4(), $composer2, 6)), TextFieldDefaults.INSTANCE.m1717getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1716getMinHeightD9Ej5fM());
            SolidColor solidColor = new SolidColor(colors2.cursorColor(isError4, $composer2, ($dirty14 & 14) | (($dirty14 >> 24) & 112)).getValue().m4197unboximpl(), null);
            final TextFieldColors colors4 = colors2;
            final boolean singleLine5 = singleLine2;
            final Function2 label3 = label;
            final Function2 placeholder3 = placeholder;
            final Function2 leadingIcon3 = leadingIcon;
            final Function2 trailingIcon3 = trailingIcon;
            final VisualTransformation visualTransformation4 = visualTransformation2;
            final Shape shape4 = shape2;
            Composer $composer5 = $composer2;
            BasicTextFieldKt.BasicTextField(value, function1, modifierM710defaultMinSizeVpY3zN4, enabled2, readOnly2, mergedTextStyle, keyboardOptions2, keyboardActions3, singleLine2, maxLines3, minLines2, visualTransformation4, (Function1<? super TextLayoutResult, Unit>) null, interactionSource5, solidColor, ComposableLambdaKt.rememberComposableLambda(989834338, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function27, Composer composer, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function27, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function27, Composer $composer6, int $changed2) {
                    Function2<? super Composer, ? super Integer, Unit> function28;
                    ComposerKt.sourceInformation($composer6, "C213@10762L570:TextField.kt#jmzs0o");
                    int $dirty7 = $changed2;
                    if (($changed2 & 6) == 0) {
                        function28 = function27;
                        $dirty7 |= $composer6.changedInstance(function28) ? 4 : 2;
                    } else {
                        function28 = function27;
                    }
                    if (($dirty7 & 19) != 18 || !$composer6.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(989834338, $dirty7, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:213)");
                        }
                        TextFieldDefaults.INSTANCE.TextFieldDecorationBox(value, function28, enabled5, singleLine5, visualTransformation4, interactionSource5, isError4, label3, placeholder3, leadingIcon3, trailingIcon3, shape4, colors4, null, $composer6, ($dirty7 << 3) & 112, 24576, 8192);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer6.skipToGroupEnd();
                }
            }, $composer2, 54), $composer5, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 7168) | (57344 & $dirty2) | (($dirty14 << 12) & 3670016) | (($dirty14 << 12) & 29360128) | (($dirty14 << 12) & 234881024) | (1879048192 & ($dirty14 << 12)), (($dirty14 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ($dirty14 & 112), 4096);
            $composer3 = $composer5;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            singleLine3 = singleLine2;
            visualTransformation3 = visualTransformation4;
            textStyle5 = textStyle6;
            modifier3 = modifier5;
            colors3 = colors4;
            enabled3 = enabled2;
            readOnly3 = readOnly2;
            maxLines4 = maxLines3;
            minLines3 = minLines2;
            label2 = label;
            placeholder2 = placeholder;
            leadingIcon2 = leadingIcon;
            interactionSource4 = interactionSource2;
            shape3 = shape2;
            keyboardOptions3 = keyboardOptions2;
            keyboardActions4 = keyboardActions3;
            trailingIcon2 = trailingIcon;
            isError3 = isError4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i24) {
                    TextFieldKt.TextField(value, function1, modifier3, enabled3, readOnly3, textStyle5, label2, placeholder2, leadingIcon2, trailingIcon2, isError3, visualTransformation3, keyboardOptions3, keyboardActions4, singleLine3, maxLines4, minLines3, interactionSource4, shape3, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final /* synthetic */ void TextField(final String value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean enabled2;
        boolean readOnly2;
        TextStyle textStyle2;
        Function2 function2;
        Function2 function22;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        TextFieldColors textFieldColors;
        int $dirty1;
        int $dirty;
        TextStyle textStyle3;
        int $dirty12;
        KeyboardActions keyboardActions2;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        int $dirty13;
        Composer $composer2;
        TextFieldColors colors2;
        KeyboardActions keyboardActions3;
        Modifier modifier3;
        TextStyle textStyle4;
        int $dirty2;
        Function2 label2;
        Function2 placeholder2;
        Function2 leadingIcon2;
        Function2 trailingIcon2;
        boolean isError2;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        boolean singleLine2;
        int maxLines2;
        MutableInteractionSource interactionSource3;
        Shape shape3;
        Object value$iv;
        final Modifier modifier4;
        final boolean enabled3;
        final boolean readOnly3;
        final TextStyle textStyle5;
        final Function2 label3;
        final Function2 placeholder3;
        final Function2 leadingIcon3;
        final Function2 label4;
        final boolean isError3;
        final VisualTransformation visualTransformation3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions4;
        final boolean singleLine3;
        final int maxLines3;
        final MutableInteractionSource interactionSource4;
        final Shape shape4;
        final TextFieldColors colors3;
        int $dirty14;
        Composer $composer3 = $composer.startRestartGroup(-1690895095);
        ComposerKt.sourceInformation($composer3, "C(TextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)243@11701L7,254@12255L39,256@12337L6,257@12462L17,259@12488L408:TextField.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty15 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i8 = i & 4;
        if (i8 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i9 = i & 8;
        if (i9 != 0) {
            $dirty3 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer3.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i10 = i & 16;
        if (i10 != 0) {
            $dirty3 |= 24576;
            readOnly2 = readOnly;
        } else if (($changed & 24576) == 0) {
            readOnly2 = readOnly;
            $dirty3 |= $composer3.changed(readOnly2) ? 16384 : 8192;
        } else {
            readOnly2 = readOnly;
        }
        if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if ((i & 32) == 0) {
                textStyle2 = textStyle;
                int i11 = $composer3.changed(textStyle2) ? 131072 : 65536;
                $dirty3 |= i11;
            } else {
                textStyle2 = textStyle;
            }
            $dirty3 |= i11;
        } else {
            textStyle2 = textStyle;
        }
        int i12 = i & 64;
        if (i12 != 0) {
            $dirty3 |= 1572864;
            function2 = label;
        } else if (($changed & 1572864) == 0) {
            function2 = label;
            $dirty3 |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        } else {
            function2 = label;
        }
        int i13 = i & 128;
        if (i13 != 0) {
            $dirty3 |= 12582912;
            function22 = placeholder;
        } else if (($changed & 12582912) == 0) {
            function22 = placeholder;
            $dirty3 |= $composer3.changedInstance(function22) ? 8388608 : 4194304;
        } else {
            function22 = placeholder;
        }
        int i14 = i & 256;
        if (i14 != 0) {
            $dirty3 |= 100663296;
            i2 = i14;
        } else if (($changed & 100663296) == 0) {
            i2 = i14;
            $dirty3 |= $composer3.changedInstance(leadingIcon) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i14;
        }
        int i15 = i & 512;
        if (i15 != 0) {
            $dirty3 |= 805306368;
            i3 = i15;
        } else if (($changed & 805306368) == 0) {
            i3 = i15;
            $dirty3 |= $composer3.changedInstance(trailingIcon) ? 536870912 : 268435456;
        } else {
            i3 = i15;
        }
        int i16 = i & 1024;
        if (i16 != 0) {
            $dirty15 |= 6;
            i4 = i16;
        } else if (($changed1 & 6) == 0) {
            i4 = i16;
            $dirty15 |= $composer3.changed(isError) ? 4 : 2;
        } else {
            i4 = i16;
        }
        int i17 = i & 2048;
        if (i17 != 0) {
            $dirty15 |= 48;
            i5 = i17;
        } else if (($changed1 & 48) == 0) {
            i5 = i17;
            $dirty15 |= $composer3.changed(visualTransformation) ? 32 : 16;
        } else {
            i5 = i17;
        }
        int i18 = i & 4096;
        if (i18 != 0) {
            $dirty15 |= 384;
            i6 = i18;
        } else {
            i6 = i18;
            if (($changed1 & 384) == 0) {
                $dirty15 |= $composer3.changed(keyboardOptions) ? 256 : 128;
            }
        }
        if (($changed1 & 3072) == 0) {
            $dirty15 |= ((i & 8192) == 0 && $composer3.changed(keyboardActions)) ? 2048 : 1024;
        }
        int i19 = i & 16384;
        if (i19 != 0) {
            $dirty15 |= 24576;
            i7 = i19;
        } else {
            i7 = i19;
            if (($changed1 & 24576) == 0) {
                $dirty15 |= $composer3.changed(singleLine) ? 16384 : 8192;
            }
        }
        int i20 = i & 32768;
        if (i20 != 0) {
            $dirty15 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed1 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            $dirty15 |= $composer3.changed(maxLines) ? 131072 : 65536;
        }
        int i21 = i & 65536;
        if (i21 != 0) {
            $dirty15 |= 1572864;
        } else if (($changed1 & 1572864) == 0) {
            $dirty15 |= $composer3.changed(interactionSource) ? 1048576 : 524288;
        }
        if (($changed1 & 12582912) == 0) {
            $dirty15 |= ((i & 131072) == 0 && $composer3.changed(shape)) ? 8388608 : 4194304;
        }
        if (($changed1 & 100663296) == 0) {
            if ((i & 262144) == 0) {
                $dirty14 = $dirty15;
                textFieldColors = colors;
                int i22 = $composer3.changed(textFieldColors) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
                $dirty1 = $dirty14 | i22;
            } else {
                $dirty14 = $dirty15;
                textFieldColors = colors;
            }
            $dirty1 = $dirty14 | i22;
        } else {
            int $dirty16 = $dirty15;
            textFieldColors = colors;
            $dirty1 = $dirty16;
        }
        int $dirty4 = $dirty3;
        if (($dirty3 & 306783379) == 306783378 && (38347923 & $dirty1) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            leadingIcon3 = leadingIcon;
            visualTransformation3 = visualTransformation;
            keyboardOptions3 = keyboardOptions;
            maxLines3 = maxLines;
            interactionSource4 = interactionSource;
            shape4 = shape;
            $composer2 = $composer3;
            colors3 = textFieldColors;
            enabled3 = enabled2;
            readOnly3 = readOnly2;
            textStyle5 = textStyle2;
            label3 = function2;
            placeholder3 = function22;
            modifier4 = modifier2;
            label4 = trailingIcon;
            isError3 = isError;
            keyboardActions4 = keyboardActions;
            singleLine3 = singleLine;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i8 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i9 != 0 ? true : enabled2;
                boolean readOnly4 = i10 != 0 ? false : readOnly2;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle3 = (TextStyle) objConsume;
                    $dirty = $dirty4 & (-458753);
                } else {
                    $dirty = $dirty4;
                    textStyle3 = textStyle2;
                }
                Function2 label5 = i12 != 0 ? null : function2;
                Function2 placeholder4 = i13 != 0 ? null : function22;
                Function2 leadingIcon4 = i2 != 0 ? null : leadingIcon;
                Function2 trailingIcon3 = i3 != 0 ? null : trailingIcon;
                boolean isError4 = i4 != 0 ? false : isError;
                VisualTransformation visualTransformation4 = i5 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions4 = i6 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                if ((i & 8192) != 0) {
                    $dirty12 = $dirty1 & (-7169);
                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                } else {
                    $dirty12 = $dirty1;
                    keyboardActions2 = keyboardActions;
                }
                boolean singleLine4 = i7 != 0 ? false : singleLine;
                int maxLines4 = i20 != 0 ? Integer.MAX_VALUE : maxLines;
                if (i21 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -53943058, "CC(remember):TextField.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    interactionSource2 = (MutableInteractionSource) value$iv;
                } else {
                    interactionSource2 = interactionSource;
                }
                if ((i & 131072) != 0) {
                    shape2 = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
                    $dirty13 = $dirty12 & (-29360129);
                } else {
                    shape2 = shape;
                    $dirty13 = $dirty12;
                }
                if ((i & 262144) != 0) {
                    $composer2 = $composer3;
                    keyboardActions3 = keyboardActions2;
                    modifier3 = modifier5;
                    colors2 = TextFieldDefaults.INSTANCE.m1722textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 0, 0, 48, 2097151);
                    $dirty1 = $dirty13 & (-234881025);
                    enabled2 = enabled4;
                    readOnly2 = readOnly4;
                    textStyle4 = textStyle3;
                    $dirty2 = $dirty;
                    label2 = label5;
                    placeholder2 = placeholder4;
                    leadingIcon2 = leadingIcon4;
                    trailingIcon2 = trailingIcon3;
                    isError2 = isError4;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions4;
                    singleLine2 = singleLine4;
                    maxLines2 = maxLines4;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                } else {
                    $composer2 = $composer3;
                    colors2 = colors;
                    keyboardActions3 = keyboardActions2;
                    modifier3 = modifier5;
                    enabled2 = enabled4;
                    readOnly2 = readOnly4;
                    textStyle4 = textStyle3;
                    $dirty2 = $dirty;
                    label2 = label5;
                    placeholder2 = placeholder4;
                    leadingIcon2 = leadingIcon4;
                    trailingIcon2 = trailingIcon3;
                    isError2 = isError4;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions4;
                    singleLine2 = singleLine4;
                    maxLines2 = maxLines4;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                    $dirty1 = $dirty13;
                }
            } else {
                $composer3.skipToGroupEnd();
                int $dirty5 = (i & 32) != 0 ? $dirty4 & (-458753) : $dirty4;
                if ((i & 8192) != 0) {
                    $dirty1 &= -7169;
                }
                if ((i & 131072) != 0) {
                    $dirty1 &= -29360129;
                }
                if ((i & 262144) != 0) {
                    $dirty1 &= -234881025;
                }
                leadingIcon2 = leadingIcon;
                trailingIcon2 = trailingIcon;
                keyboardOptions2 = keyboardOptions;
                keyboardActions3 = keyboardActions;
                singleLine2 = singleLine;
                maxLines2 = maxLines;
                interactionSource3 = interactionSource;
                shape3 = shape;
                $composer2 = $composer3;
                $dirty2 = $dirty5;
                colors2 = textFieldColors;
                textStyle4 = textStyle2;
                label2 = function2;
                placeholder2 = function22;
                modifier3 = modifier2;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1690895095, $dirty2, $dirty1, "androidx.compose.material.TextField (TextField.kt:258)");
            }
            TextField(value, (Function1<? super String, Unit>) onValueChange, modifier3, enabled2, readOnly2, textStyle4, (Function2<? super Composer, ? super Integer, Unit>) label2, (Function2<? super Composer, ? super Integer, Unit>) placeholder2, (Function2<? super Composer, ? super Integer, Unit>) leadingIcon2, (Function2<? super Composer, ? super Integer, Unit>) trailingIcon2, isError2, visualTransformation2, keyboardOptions2, keyboardActions3, singleLine2, maxLines2, 1, interactionSource3, shape3, colors2, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | (57344 & $dirty2) | (458752 & $dirty2) | (3670016 & $dirty2) | (29360128 & $dirty2) | (234881024 & $dirty2) | (1879048192 & $dirty2), ($dirty1 & 14) | 1572864 | ($dirty1 & 112) | ($dirty1 & 896) | ($dirty1 & 7168) | (57344 & $dirty1) | (458752 & $dirty1) | (($dirty1 << 3) & 29360128) | (($dirty1 << 3) & 234881024) | (($dirty1 << 3) & 1879048192), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            enabled3 = enabled2;
            readOnly3 = readOnly2;
            textStyle5 = textStyle4;
            label3 = label2;
            placeholder3 = placeholder2;
            leadingIcon3 = leadingIcon2;
            label4 = trailingIcon2;
            isError3 = isError2;
            visualTransformation3 = visualTransformation2;
            keyboardOptions3 = keyboardOptions2;
            keyboardActions4 = keyboardActions3;
            singleLine3 = singleLine2;
            maxLines3 = maxLines2;
            interactionSource4 = interactionSource3;
            shape4 = shape3;
            colors3 = colors2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i23) {
                    TextFieldKt.TextField(value, onValueChange, modifier4, enabled3, readOnly3, textStyle5, label3, placeholder3, leadingIcon3, label4, isError3, visualTransformation3, keyboardOptions3, keyboardActions4, singleLine3, maxLines3, interactionSource4, shape4, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void TextField(final TextFieldValue value, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean enabled2;
        boolean readOnly2;
        TextStyle textStyle2;
        Function2 function25;
        Function2 function26;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        TextFieldColors textFieldColors;
        int $dirty1;
        int i8;
        int $dirty;
        TextStyle textStyle3;
        Function2 label;
        Function2 placeholder;
        Function2 leadingIcon;
        Function2 trailingIcon;
        boolean isError2;
        VisualTransformation visualTransformation2;
        int $dirty12;
        KeyboardActions keyboardActions2;
        int maxLines2;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        int $dirty13;
        Composer $composer2;
        TextFieldColors colors2;
        KeyboardActions keyboardActions3;
        TextStyle textStyle4;
        int $dirty2;
        KeyboardOptions keyboardOptions2;
        boolean singleLine2;
        int maxLines3;
        int minLines2;
        int $dirty3;
        int $dirty14;
        MutableInteractionSource interactionSource3;
        Composer $composer3;
        final boolean singleLine3;
        final VisualTransformation visualTransformation3;
        final TextStyle textStyle5;
        final Modifier modifier3;
        final TextFieldColors colors3;
        final boolean enabled3;
        final boolean readOnly3;
        final int maxLines4;
        final int minLines3;
        final Function2 label2;
        final Function2 placeholder2;
        final Function2 leadingIcon2;
        final MutableInteractionSource interactionSource4;
        final Shape shape3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions4;
        final Function2 trailingIcon2;
        final boolean isError3;
        Object value$iv;
        int $dirty15;
        Composer $composer4 = $composer.startRestartGroup(-359119489);
        ComposerKt.sourceInformation($composer4, "C(TextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)356@17778L7,369@18422L14,370@18486L17,385@19110L38,394@19477L20,402@19819L724,381@18927L1622:TextField.kt#jmzs0o");
        int $dirty4 = $changed;
        int $dirty16 = $changed1;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty4 |= $composer4.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty4 |= $composer4.changedInstance(function1) ? 32 : 16;
        }
        int i9 = i & 4;
        if (i9 != 0) {
            $dirty4 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer4.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i10 = i & 8;
        if (i10 != 0) {
            $dirty4 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty4 |= $composer4.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i11 = i & 16;
        if (i11 != 0) {
            $dirty4 |= 24576;
            readOnly2 = readOnly;
        } else if (($changed & 24576) == 0) {
            readOnly2 = readOnly;
            $dirty4 |= $composer4.changed(readOnly2) ? 16384 : 8192;
        } else {
            readOnly2 = readOnly;
        }
        if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if ((i & 32) == 0) {
                textStyle2 = textStyle;
                int i12 = $composer4.changed(textStyle2) ? 131072 : 65536;
                $dirty4 |= i12;
            } else {
                textStyle2 = textStyle;
            }
            $dirty4 |= i12;
        } else {
            textStyle2 = textStyle;
        }
        int i13 = i & 64;
        if (i13 != 0) {
            $dirty4 |= 1572864;
            function25 = function2;
        } else if (($changed & 1572864) == 0) {
            function25 = function2;
            $dirty4 |= $composer4.changedInstance(function25) ? 1048576 : 524288;
        } else {
            function25 = function2;
        }
        int i14 = i & 128;
        if (i14 != 0) {
            $dirty4 |= 12582912;
            function26 = function22;
        } else if (($changed & 12582912) == 0) {
            function26 = function22;
            $dirty4 |= $composer4.changedInstance(function26) ? 8388608 : 4194304;
        } else {
            function26 = function22;
        }
        int i15 = i & 256;
        if (i15 != 0) {
            $dirty4 |= 100663296;
            i2 = i15;
        } else if (($changed & 100663296) == 0) {
            i2 = i15;
            $dirty4 |= $composer4.changedInstance(function23) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i15;
        }
        int i16 = i & 512;
        if (i16 != 0) {
            $dirty4 |= 805306368;
            i3 = i16;
        } else if (($changed & 805306368) == 0) {
            i3 = i16;
            $dirty4 |= $composer4.changedInstance(function24) ? 536870912 : 268435456;
        } else {
            i3 = i16;
        }
        int i17 = i & 1024;
        if (i17 != 0) {
            $dirty16 |= 6;
            i4 = i17;
        } else if (($changed1 & 6) == 0) {
            i4 = i17;
            $dirty16 |= $composer4.changed(isError) ? 4 : 2;
        } else {
            i4 = i17;
        }
        int i18 = i & 2048;
        if (i18 != 0) {
            $dirty16 |= 48;
            i5 = i18;
        } else if (($changed1 & 48) == 0) {
            i5 = i18;
            $dirty16 |= $composer4.changed(visualTransformation) ? 32 : 16;
        } else {
            i5 = i18;
        }
        int i19 = i & 4096;
        if (i19 != 0) {
            $dirty16 |= 384;
            i6 = i19;
        } else {
            i6 = i19;
            if (($changed1 & 384) == 0) {
                $dirty16 |= $composer4.changed(keyboardOptions) ? 256 : 128;
            }
        }
        if (($changed1 & 3072) == 0) {
            $dirty16 |= ((i & 8192) == 0 && $composer4.changed(keyboardActions)) ? 2048 : 1024;
        }
        int i20 = i & 16384;
        if (i20 != 0) {
            $dirty16 |= 24576;
            i7 = i20;
        } else {
            i7 = i20;
            if (($changed1 & 24576) == 0) {
                $dirty16 |= $composer4.changed(singleLine) ? 16384 : 8192;
            }
        }
        if (($changed1 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            $dirty16 |= ((i & 32768) == 0 && $composer4.changed(maxLines)) ? 131072 : 65536;
        }
        int i21 = i & 65536;
        if (i21 != 0) {
            $dirty16 |= 1572864;
        } else if (($changed1 & 1572864) == 0) {
            $dirty16 |= $composer4.changed(minLines) ? 1048576 : 524288;
        }
        int i22 = i & 131072;
        if (i22 != 0) {
            $dirty16 |= 12582912;
        } else if (($changed1 & 12582912) == 0) {
            $dirty16 |= $composer4.changed(interactionSource) ? 8388608 : 4194304;
        }
        if (($changed1 & 100663296) == 0) {
            $dirty16 |= ((i & 262144) == 0 && $composer4.changed(shape)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed1 & 805306368) == 0) {
            if ((i & 524288) == 0) {
                $dirty15 = $dirty16;
                textFieldColors = colors;
                int i23 = $composer4.changed(textFieldColors) ? 536870912 : 268435456;
                $dirty1 = $dirty15 | i23;
            } else {
                $dirty15 = $dirty16;
                textFieldColors = colors;
            }
            $dirty1 = $dirty15 | i23;
        } else {
            int $dirty17 = $dirty16;
            textFieldColors = colors;
            $dirty1 = $dirty17;
        }
        int $dirty5 = $dirty4;
        if (($dirty4 & 306783379) == 306783378 && (306783379 & $dirty1) == 306783378 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            leadingIcon2 = function23;
            visualTransformation3 = visualTransformation;
            keyboardOptions3 = keyboardOptions;
            maxLines4 = maxLines;
            minLines3 = minLines;
            interactionSource4 = interactionSource;
            shape3 = shape;
            $composer3 = $composer4;
            colors3 = textFieldColors;
            enabled3 = enabled2;
            readOnly3 = readOnly2;
            textStyle5 = textStyle2;
            label2 = function25;
            placeholder2 = function26;
            modifier3 = modifier2;
            trailingIcon2 = function24;
            isError3 = isError;
            keyboardActions4 = keyboardActions;
            singleLine3 = singleLine;
        } else {
            $composer4.startDefaults();
            if (($changed & 1) == 0 || $composer4.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i9 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i10 != 0 ? true : enabled2;
                boolean readOnly4 = i11 != 0 ? false : readOnly2;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    i8 = -458753;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer4.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    textStyle3 = (TextStyle) objConsume;
                    $dirty = $dirty5 & (-458753);
                } else {
                    i8 = -458753;
                    $dirty = $dirty5;
                    textStyle3 = textStyle2;
                }
                label = i13 != 0 ? null : function25;
                placeholder = i14 != 0 ? null : function26;
                leadingIcon = i2 != 0 ? null : function23;
                trailingIcon = i3 != 0 ? null : function24;
                isError2 = i4 != 0 ? false : isError;
                visualTransformation2 = i5 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions4 = i6 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                if ((i & 8192) != 0) {
                    $dirty12 = $dirty1 & (-7169);
                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                } else {
                    $dirty12 = $dirty1;
                    keyboardActions2 = keyboardActions;
                }
                boolean singleLine4 = i7 != 0 ? false : singleLine;
                if ((32768 & i) != 0) {
                    $dirty12 &= i8;
                    maxLines2 = singleLine4 ? 1 : Integer.MAX_VALUE;
                } else {
                    maxLines2 = maxLines;
                }
                int minLines4 = i21 != 0 ? 1 : minLines;
                interactionSource2 = i22 != 0 ? null : interactionSource;
                if ((262144 & i) != 0) {
                    shape2 = TextFieldDefaults.INSTANCE.getTextFieldShape($composer4, 6);
                    $dirty13 = $dirty12 & (-234881025);
                } else {
                    shape2 = shape;
                    $dirty13 = $dirty12;
                }
                if ((i & 524288) != 0) {
                    colors2 = TextFieldDefaults.INSTANCE.m1722textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer4, 0, 0, 48, 2097151);
                    $composer2 = $composer4;
                    keyboardActions3 = keyboardActions2;
                    modifier2 = modifier4;
                    $dirty3 = $dirty13 & (-1879048193);
                    enabled2 = enabled4;
                    readOnly2 = readOnly4;
                    textStyle4 = textStyle3;
                    $dirty2 = $dirty;
                    keyboardOptions2 = keyboardOptions4;
                    singleLine2 = singleLine4;
                    maxLines3 = maxLines2;
                    minLines2 = minLines4;
                } else {
                    $composer2 = $composer4;
                    colors2 = colors;
                    keyboardActions3 = keyboardActions2;
                    modifier2 = modifier4;
                    enabled2 = enabled4;
                    readOnly2 = readOnly4;
                    textStyle4 = textStyle3;
                    $dirty2 = $dirty;
                    keyboardOptions2 = keyboardOptions4;
                    singleLine2 = singleLine4;
                    maxLines3 = maxLines2;
                    minLines2 = minLines4;
                    $dirty3 = $dirty13;
                }
            } else {
                $composer4.skipToGroupEnd();
                int $dirty6 = (i & 32) != 0 ? $dirty5 & (-458753) : $dirty5;
                if ((i & 8192) != 0) {
                    $dirty1 &= -7169;
                }
                if ((32768 & i) != 0) {
                    $dirty1 &= -458753;
                }
                if ((262144 & i) != 0) {
                    $dirty1 &= -234881025;
                }
                if ((i & 524288) != 0) {
                    $dirty1 &= -1879048193;
                }
                leadingIcon = function23;
                trailingIcon = function24;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
                singleLine2 = singleLine;
                maxLines3 = maxLines;
                interactionSource2 = interactionSource;
                shape2 = shape;
                colors2 = colors;
                $dirty2 = $dirty6;
                $composer2 = $composer4;
                label = function25;
                placeholder = function26;
                keyboardActions3 = keyboardActions;
                minLines2 = minLines;
                $dirty3 = $dirty1;
                textStyle4 = textStyle2;
                keyboardOptions2 = keyboardOptions;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-359119489, $dirty2, $dirty3, "androidx.compose.material.TextField (TextField.kt:371)");
            }
            if (interactionSource2 == null) {
                $composer2.startReplaceGroup(-1665951468);
                ComposerKt.sourceInformation($composer2, "373@18589L39");
                ComposerKt.sourceInformationMarkerStart($composer2, -53740370, "CC(remember):TextField.kt#9igjgp");
                Composer $this$cache$iv = $composer2;
                $dirty14 = $dirty3;
                Object it$iv = $this$cache$iv.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = InteractionSourceKt.MutableInteractionSource();
                    $this$cache$iv.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                interactionSource3 = (MutableInteractionSource) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            } else {
                $dirty14 = $dirty3;
                $composer2.startReplaceGroup(-53741021);
                $composer2.endReplaceGroup();
                interactionSource3 = interactionSource2;
            }
            $composer2.startReplaceGroup(-53735263);
            ComposerKt.sourceInformation($composer2, "*376@18776L18");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle4.m6176getColor0d7_KjU();
            if (!($this$takeOrElse_u2dDxMtmZc$iv != 16)) {
                $this$takeOrElse_u2dDxMtmZc$iv = colors2.textColor(enabled2, $composer2, (($dirty2 >> 9) & 14) | (($dirty14 >> 24) & 112)).getValue().m4197unboximpl();
            }
            $composer2.endReplaceGroup();
            long textColor = $this$takeOrElse_u2dDxMtmZc$iv;
            TextStyle mergedTextStyle = textStyle4.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            final boolean enabled5 = enabled2;
            Modifier modifier5 = modifier2;
            final boolean isError4 = isError2;
            TextStyle textStyle6 = textStyle4;
            final MutableInteractionSource interactionSource5 = interactionSource3;
            Modifier modifierM710defaultMinSizeVpY3zN4 = SizeKt.m710defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m1710indicatorLinegv0btCI$default(TextFieldDefaults.INSTANCE, modifier5, enabled5, isError4, interactionSource3, colors2, 0.0f, 0.0f, 48, null), isError4, Strings_androidKt.m1675getString4foXLRw(Strings.INSTANCE.m1670getDefaultErrorMessageUdPEhr4(), $composer2, 6)), TextFieldDefaults.INSTANCE.m1717getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1716getMinHeightD9Ej5fM());
            SolidColor solidColor = new SolidColor(colors2.cursorColor(isError4, $composer2, ($dirty14 & 14) | (($dirty14 >> 24) & 112)).getValue().m4197unboximpl(), null);
            final TextFieldColors colors4 = colors2;
            final boolean singleLine5 = singleLine2;
            final Function2 label3 = label;
            final Function2 placeholder3 = placeholder;
            final Function2 leadingIcon3 = leadingIcon;
            final Function2 trailingIcon3 = trailingIcon;
            final VisualTransformation visualTransformation4 = visualTransformation2;
            final Shape shape4 = shape2;
            Composer $composer5 = $composer2;
            BasicTextFieldKt.BasicTextField(value, function1, modifierM710defaultMinSizeVpY3zN4, enabled2, readOnly2, mergedTextStyle, keyboardOptions2, keyboardActions3, singleLine2, maxLines3, minLines2, visualTransformation4, (Function1<? super TextLayoutResult, Unit>) null, interactionSource5, solidColor, ComposableLambdaKt.rememberComposableLambda(-126640971, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function27, Composer composer, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function27, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function27, Composer $composer6, int $changed2) {
                    Function2<? super Composer, ? super Integer, Unit> function28;
                    ComposerKt.sourceInformation($composer6, "C404@19958L575:TextField.kt#jmzs0o");
                    int $dirty7 = $changed2;
                    if (($changed2 & 6) == 0) {
                        function28 = function27;
                        $dirty7 |= $composer6.changedInstance(function28) ? 4 : 2;
                    } else {
                        function28 = function27;
                    }
                    if (($dirty7 & 19) == 18 && $composer6.getSkipping()) {
                        $composer6.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-126640971, $dirty7, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:404)");
                    }
                    TextFieldDefaults.INSTANCE.TextFieldDecorationBox(value.getText(), function28, enabled5, singleLine5, visualTransformation4, interactionSource5, isError4, label3, placeholder3, leadingIcon3, trailingIcon3, shape4, colors4, null, $composer6, ($dirty7 << 3) & 112, 24576, 8192);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer5, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 7168) | (57344 & $dirty2) | (($dirty14 << 12) & 3670016) | (($dirty14 << 12) & 29360128) | (($dirty14 << 12) & 234881024) | (1879048192 & ($dirty14 << 12)), (($dirty14 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ($dirty14 & 112), 4096);
            $composer3 = $composer5;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            singleLine3 = singleLine2;
            visualTransformation3 = visualTransformation4;
            textStyle5 = textStyle6;
            modifier3 = modifier5;
            colors3 = colors4;
            enabled3 = enabled2;
            readOnly3 = readOnly2;
            maxLines4 = maxLines3;
            minLines3 = minLines2;
            label2 = label;
            placeholder2 = placeholder;
            leadingIcon2 = leadingIcon;
            interactionSource4 = interactionSource2;
            shape3 = shape2;
            keyboardOptions3 = keyboardOptions2;
            keyboardActions4 = keyboardActions3;
            trailingIcon2 = trailingIcon;
            isError3 = isError4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i24) {
                    TextFieldKt.TextField(value, function1, modifier3, enabled3, readOnly3, textStyle5, label2, placeholder2, leadingIcon2, trailingIcon2, isError3, visualTransformation3, keyboardOptions3, keyboardActions4, singleLine3, maxLines4, minLines3, interactionSource4, shape3, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final /* synthetic */ void TextField(final TextFieldValue value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean enabled2;
        boolean readOnly2;
        TextStyle textStyle2;
        Function2 function2;
        Function2 function22;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        TextFieldColors textFieldColors;
        int $dirty1;
        int $dirty;
        TextStyle textStyle3;
        int $dirty12;
        KeyboardActions keyboardActions2;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        int $dirty13;
        Composer $composer2;
        TextFieldColors colors2;
        KeyboardActions keyboardActions3;
        Modifier modifier3;
        TextStyle textStyle4;
        int $dirty2;
        Function2 label2;
        Function2 placeholder2;
        Function2 leadingIcon2;
        Function2 trailingIcon2;
        boolean isError2;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        boolean singleLine2;
        int maxLines2;
        MutableInteractionSource interactionSource3;
        Shape shape3;
        Object value$iv;
        final Modifier modifier4;
        final boolean enabled3;
        final boolean readOnly3;
        final TextStyle textStyle5;
        final Function2 label3;
        final Function2 placeholder3;
        final Function2 leadingIcon3;
        final Function2 label4;
        final boolean isError3;
        final VisualTransformation visualTransformation3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions4;
        final boolean singleLine3;
        final int maxLines3;
        final MutableInteractionSource interactionSource4;
        final Shape shape4;
        final TextFieldColors colors3;
        int $dirty14;
        Composer $composer3 = $composer.startRestartGroup(-1576622884);
        ComposerKt.sourceInformation($composer3, "C(TextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)434@20918L7,445@21472L39,446@21550L14,447@21614L17,449@21640L408:TextField.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty15 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i8 = i & 4;
        if (i8 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i9 = i & 8;
        if (i9 != 0) {
            $dirty3 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer3.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i10 = i & 16;
        if (i10 != 0) {
            $dirty3 |= 24576;
            readOnly2 = readOnly;
        } else if (($changed & 24576) == 0) {
            readOnly2 = readOnly;
            $dirty3 |= $composer3.changed(readOnly2) ? 16384 : 8192;
        } else {
            readOnly2 = readOnly;
        }
        if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if ((i & 32) == 0) {
                textStyle2 = textStyle;
                int i11 = $composer3.changed(textStyle2) ? 131072 : 65536;
                $dirty3 |= i11;
            } else {
                textStyle2 = textStyle;
            }
            $dirty3 |= i11;
        } else {
            textStyle2 = textStyle;
        }
        int i12 = i & 64;
        if (i12 != 0) {
            $dirty3 |= 1572864;
            function2 = label;
        } else if (($changed & 1572864) == 0) {
            function2 = label;
            $dirty3 |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        } else {
            function2 = label;
        }
        int i13 = i & 128;
        if (i13 != 0) {
            $dirty3 |= 12582912;
            function22 = placeholder;
        } else if (($changed & 12582912) == 0) {
            function22 = placeholder;
            $dirty3 |= $composer3.changedInstance(function22) ? 8388608 : 4194304;
        } else {
            function22 = placeholder;
        }
        int i14 = i & 256;
        if (i14 != 0) {
            $dirty3 |= 100663296;
            i2 = i14;
        } else if (($changed & 100663296) == 0) {
            i2 = i14;
            $dirty3 |= $composer3.changedInstance(leadingIcon) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i14;
        }
        int i15 = i & 512;
        if (i15 != 0) {
            $dirty3 |= 805306368;
            i3 = i15;
        } else if (($changed & 805306368) == 0) {
            i3 = i15;
            $dirty3 |= $composer3.changedInstance(trailingIcon) ? 536870912 : 268435456;
        } else {
            i3 = i15;
        }
        int i16 = i & 1024;
        if (i16 != 0) {
            $dirty15 |= 6;
            i4 = i16;
        } else if (($changed1 & 6) == 0) {
            i4 = i16;
            $dirty15 |= $composer3.changed(isError) ? 4 : 2;
        } else {
            i4 = i16;
        }
        int i17 = i & 2048;
        if (i17 != 0) {
            $dirty15 |= 48;
            i5 = i17;
        } else if (($changed1 & 48) == 0) {
            i5 = i17;
            $dirty15 |= $composer3.changed(visualTransformation) ? 32 : 16;
        } else {
            i5 = i17;
        }
        int i18 = i & 4096;
        if (i18 != 0) {
            $dirty15 |= 384;
            i6 = i18;
        } else {
            i6 = i18;
            if (($changed1 & 384) == 0) {
                $dirty15 |= $composer3.changed(keyboardOptions) ? 256 : 128;
            }
        }
        if (($changed1 & 3072) == 0) {
            $dirty15 |= ((i & 8192) == 0 && $composer3.changed(keyboardActions)) ? 2048 : 1024;
        }
        int i19 = i & 16384;
        if (i19 != 0) {
            $dirty15 |= 24576;
            i7 = i19;
        } else {
            i7 = i19;
            if (($changed1 & 24576) == 0) {
                $dirty15 |= $composer3.changed(singleLine) ? 16384 : 8192;
            }
        }
        int i20 = i & 32768;
        if (i20 != 0) {
            $dirty15 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed1 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            $dirty15 |= $composer3.changed(maxLines) ? 131072 : 65536;
        }
        int i21 = i & 65536;
        if (i21 != 0) {
            $dirty15 |= 1572864;
        } else if (($changed1 & 1572864) == 0) {
            $dirty15 |= $composer3.changed(interactionSource) ? 1048576 : 524288;
        }
        if (($changed1 & 12582912) == 0) {
            $dirty15 |= ((i & 131072) == 0 && $composer3.changed(shape)) ? 8388608 : 4194304;
        }
        if (($changed1 & 100663296) == 0) {
            if ((i & 262144) == 0) {
                $dirty14 = $dirty15;
                textFieldColors = colors;
                int i22 = $composer3.changed(textFieldColors) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
                $dirty1 = $dirty14 | i22;
            } else {
                $dirty14 = $dirty15;
                textFieldColors = colors;
            }
            $dirty1 = $dirty14 | i22;
        } else {
            int $dirty16 = $dirty15;
            textFieldColors = colors;
            $dirty1 = $dirty16;
        }
        int $dirty4 = $dirty3;
        if (($dirty3 & 306783379) == 306783378 && (38347923 & $dirty1) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            leadingIcon3 = leadingIcon;
            visualTransformation3 = visualTransformation;
            keyboardOptions3 = keyboardOptions;
            maxLines3 = maxLines;
            interactionSource4 = interactionSource;
            shape4 = shape;
            $composer2 = $composer3;
            colors3 = textFieldColors;
            enabled3 = enabled2;
            readOnly3 = readOnly2;
            textStyle5 = textStyle2;
            label3 = function2;
            placeholder3 = function22;
            modifier4 = modifier2;
            label4 = trailingIcon;
            isError3 = isError;
            keyboardActions4 = keyboardActions;
            singleLine3 = singleLine;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i8 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i9 != 0 ? true : enabled2;
                boolean readOnly4 = i10 != 0 ? false : readOnly2;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle3 = (TextStyle) objConsume;
                    $dirty = $dirty4 & (-458753);
                } else {
                    $dirty = $dirty4;
                    textStyle3 = textStyle2;
                }
                Function2 label5 = i12 != 0 ? null : function2;
                Function2 placeholder4 = i13 != 0 ? null : function22;
                Function2 leadingIcon4 = i2 != 0 ? null : leadingIcon;
                Function2 trailingIcon3 = i3 != 0 ? null : trailingIcon;
                boolean isError4 = i4 != 0 ? false : isError;
                VisualTransformation visualTransformation4 = i5 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions4 = i6 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                if ((i & 8192) != 0) {
                    $dirty12 = $dirty1 & (-7169);
                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                } else {
                    $dirty12 = $dirty1;
                    keyboardActions2 = keyboardActions;
                }
                boolean singleLine4 = i7 != 0 ? false : singleLine;
                int maxLines4 = i20 != 0 ? Integer.MAX_VALUE : maxLines;
                if (i21 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -53648114, "CC(remember):TextField.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    interactionSource2 = (MutableInteractionSource) value$iv;
                } else {
                    interactionSource2 = interactionSource;
                }
                if ((i & 131072) != 0) {
                    shape2 = TextFieldDefaults.INSTANCE.getTextFieldShape($composer3, 6);
                    $dirty13 = $dirty12 & (-29360129);
                } else {
                    shape2 = shape;
                    $dirty13 = $dirty12;
                }
                if ((i & 262144) != 0) {
                    $composer2 = $composer3;
                    keyboardActions3 = keyboardActions2;
                    modifier3 = modifier5;
                    colors2 = TextFieldDefaults.INSTANCE.m1722textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 0, 0, 48, 2097151);
                    $dirty1 = $dirty13 & (-234881025);
                    enabled2 = enabled4;
                    readOnly2 = readOnly4;
                    textStyle4 = textStyle3;
                    $dirty2 = $dirty;
                    label2 = label5;
                    placeholder2 = placeholder4;
                    leadingIcon2 = leadingIcon4;
                    trailingIcon2 = trailingIcon3;
                    isError2 = isError4;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions4;
                    singleLine2 = singleLine4;
                    maxLines2 = maxLines4;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                } else {
                    $composer2 = $composer3;
                    colors2 = colors;
                    keyboardActions3 = keyboardActions2;
                    modifier3 = modifier5;
                    enabled2 = enabled4;
                    readOnly2 = readOnly4;
                    textStyle4 = textStyle3;
                    $dirty2 = $dirty;
                    label2 = label5;
                    placeholder2 = placeholder4;
                    leadingIcon2 = leadingIcon4;
                    trailingIcon2 = trailingIcon3;
                    isError2 = isError4;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions4;
                    singleLine2 = singleLine4;
                    maxLines2 = maxLines4;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                    $dirty1 = $dirty13;
                }
            } else {
                $composer3.skipToGroupEnd();
                int $dirty5 = (i & 32) != 0 ? $dirty4 & (-458753) : $dirty4;
                if ((i & 8192) != 0) {
                    $dirty1 &= -7169;
                }
                if ((i & 131072) != 0) {
                    $dirty1 &= -29360129;
                }
                if ((i & 262144) != 0) {
                    $dirty1 &= -234881025;
                }
                leadingIcon2 = leadingIcon;
                trailingIcon2 = trailingIcon;
                keyboardOptions2 = keyboardOptions;
                keyboardActions3 = keyboardActions;
                singleLine2 = singleLine;
                maxLines2 = maxLines;
                interactionSource3 = interactionSource;
                shape3 = shape;
                $composer2 = $composer3;
                $dirty2 = $dirty5;
                colors2 = textFieldColors;
                textStyle4 = textStyle2;
                label2 = function2;
                placeholder2 = function22;
                modifier3 = modifier2;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1576622884, $dirty2, $dirty1, "androidx.compose.material.TextField (TextField.kt:448)");
            }
            TextField(value, (Function1<? super TextFieldValue, Unit>) onValueChange, modifier3, enabled2, readOnly2, textStyle4, (Function2<? super Composer, ? super Integer, Unit>) label2, (Function2<? super Composer, ? super Integer, Unit>) placeholder2, (Function2<? super Composer, ? super Integer, Unit>) leadingIcon2, (Function2<? super Composer, ? super Integer, Unit>) trailingIcon2, isError2, visualTransformation2, keyboardOptions2, keyboardActions3, singleLine2, maxLines2, 1, interactionSource3, shape3, colors2, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | (57344 & $dirty2) | (458752 & $dirty2) | (3670016 & $dirty2) | (29360128 & $dirty2) | (234881024 & $dirty2) | (1879048192 & $dirty2), ($dirty1 & 14) | 1572864 | ($dirty1 & 112) | ($dirty1 & 896) | ($dirty1 & 7168) | (57344 & $dirty1) | (458752 & $dirty1) | (($dirty1 << 3) & 29360128) | (($dirty1 << 3) & 234881024) | (($dirty1 << 3) & 1879048192), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            enabled3 = enabled2;
            readOnly3 = readOnly2;
            textStyle5 = textStyle4;
            label3 = label2;
            placeholder3 = placeholder2;
            leadingIcon3 = leadingIcon2;
            label4 = trailingIcon2;
            isError3 = isError2;
            visualTransformation3 = visualTransformation2;
            keyboardOptions3 = keyboardOptions2;
            keyboardActions4 = keyboardActions3;
            singleLine3 = singleLine2;
            maxLines3 = maxLines2;
            interactionSource4 = interactionSource3;
            shape4 = shape3;
            colors3 = colors2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextField.8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i23) {
                    TextFieldKt.TextField(value, onValueChange, modifier4, enabled3, readOnly3, textStyle5, label3, placeholder3, leadingIcon3, label4, isError3, visualTransformation3, keyboardOptions3, keyboardActions4, singleLine3, maxLines3, interactionSource4, shape4, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1096)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1050)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:118)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x04f4  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x054b  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x068f  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0701  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x070d  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0713  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0744  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0758  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x07da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void TextFieldLayout(final androidx.compose.ui.Modifier r54, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, final kotlin.jvm.functions.Function3<? super androidx.compose.ui.Modifier, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r57, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r59, final boolean r60, final float r61, final androidx.compose.foundation.layout.PaddingValues r62, androidx.compose.runtime.Composer r63, final int r64) {
        /*
            Method dump skipped, instructions count: 2047
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextFieldLayout(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int substractConstraintSafely(int $this$substractConstraintSafely, int from) {
        if ($this$substractConstraintSafely == Integer.MAX_VALUE) {
            return $this$substractConstraintSafely;
        }
        return $this$substractConstraintSafely - from;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-VsPV1Ek, reason: not valid java name */
    public static final int m1734calculateWidthVsPV1Ek(int leadingWidth, int trailingWidth, int textFieldWidth, int labelWidth, int placeholderWidth, long constraints) {
        int middleSection = Math.max(textFieldWidth, Math.max(labelWidth, placeholderWidth));
        int wrappedWidth = leadingWidth + middleSection + trailingWidth;
        return Math.max(wrappedWidth, Constraints.m6638getMinWidthimpl(constraints));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-O3s9Psw, reason: not valid java name */
    public static final int m1733calculateHeightO3s9Psw(int textFieldHeight, boolean hasLabel, int labelBaseline, int leadingHeight, int trailingHeight, int placeholderHeight, long constraints, float density, PaddingValues paddingValues) {
        float middleSectionHeight;
        float paddingToLabel = TextFieldTopPadding * density;
        float topPaddingValue = paddingValues.getTop() * density;
        float bottomPaddingValue = paddingValues.getBottom() * density;
        int inputFieldHeight = Math.max(textFieldHeight, placeholderHeight);
        if (hasLabel) {
            middleSectionHeight = labelBaseline + paddingToLabel + inputFieldHeight + bottomPaddingValue;
        } else {
            middleSectionHeight = inputFieldHeight + topPaddingValue + bottomPaddingValue;
        }
        return Math.max(MathKt.roundToInt(middleSectionHeight), Math.max(Math.max(leadingHeight, trailingHeight), Constraints.m6637getMinHeightimpl(constraints)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope $this$placeWithLabel, int width, int height, Placeable textfieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, boolean singleLine, int labelEndPosition, int textPosition, float animationProgress, float density) {
        int startPosition;
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, leadingPlaceable, 0, Alignment.INSTANCE.getCenterVertically().align(leadingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.INSTANCE.getCenterVertically().align(trailingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (labelPlaceable != null) {
            if (singleLine) {
                startPosition = Alignment.INSTANCE.getCenterVertically().align(labelPlaceable.getHeight(), height);
            } else {
                startPosition = MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * density);
            }
            int distance = startPosition - labelEndPosition;
            int positionY = startPosition - MathKt.roundToInt(distance * animationProgress);
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, labelPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), positionY, 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, textfieldPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textPosition, 0.0f, 4, null);
        if (placeholderPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, placeholderPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textPosition, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope $this$placeWithoutLabel, int width, int height, Placeable textPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, boolean singleLine, float density, PaddingValues paddingValues) {
        int textVerticalPosition;
        int placeholderVerticalPosition;
        int topPadding = MathKt.roundToInt(paddingValues.getTop() * density);
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, leadingPlaceable, 0, Alignment.INSTANCE.getCenterVertically().align(leadingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.INSTANCE.getCenterVertically().align(trailingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (singleLine) {
            textVerticalPosition = Alignment.INSTANCE.getCenterVertically().align(textPlaceable.getHeight(), height);
        } else {
            textVerticalPosition = topPadding;
        }
        Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, textPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textVerticalPosition, 0.0f, 4, null);
        if (placeholderPlaceable != null) {
            if (singleLine) {
                placeholderVerticalPosition = Alignment.INSTANCE.getCenterVertically().align(placeholderPlaceable.getHeight(), height);
            } else {
                placeholderVerticalPosition = topPadding;
            }
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, placeholderPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), placeholderVerticalPosition, 0.0f, 4, null);
        }
    }

    public static final Modifier drawIndicatorLine(Modifier $this$drawIndicatorLine, final BorderStroke indicatorBorder) {
        final float strokeWidthDp = indicatorBorder.getWidth();
        return DrawModifierKt.drawWithContent($this$drawIndicatorLine, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material.TextFieldKt.drawIndicatorLine.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope $this$drawWithContent) {
                $this$drawWithContent.drawContent();
                if (Dp.m6698equalsimpl0(strokeWidthDp, Dp.INSTANCE.m6711getHairlineD9Ej5fM())) {
                    return;
                }
                float strokeWidth = strokeWidthDp * $this$drawWithContent.getDensity();
                float y = Size.m4011getHeightimpl($this$drawWithContent.mo4662getSizeNHjbRc()) - (strokeWidth / 2.0f);
                DrawScope.CC.m4738drawLine1RTmtNc$default($this$drawWithContent, indicatorBorder.getBrush(), OffsetKt.Offset(0.0f, y), OffsetKt.Offset(Size.m4014getWidthimpl($this$drawWithContent.mo4662getSizeNHjbRc()), y), strokeWidth, 0, null, 0.0f, null, 0, 496, null);
            }
        });
    }

    public static final float getFirstBaselineOffset() {
        return FirstBaselineOffset;
    }

    public static final float getTextFieldBottomPadding() {
        return TextFieldBottomPadding;
    }

    public static final float getTextFieldTopPadding() {
        return TextFieldTopPadding;
    }
}
