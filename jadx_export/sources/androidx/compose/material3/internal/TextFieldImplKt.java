package androidx.compose.material3.internal;

import androidx.autofill.HintConstants;
import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.FloatCompanionObject;

/* compiled from: TextFieldImpl.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0002\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00012\u0011\u00102\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b42\u0006\u00105\u001a\u0002062\u0013\u00107\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u00108\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u00109\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010:\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010;\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010<\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010=\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2\b\b\u0002\u0010A\u001a\u00020?2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0011\u0010H\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b4H\u0001¢\u0006\u0002\u0010I\u001a-\u0010J\u001a\u00020.2\u0006\u0010K\u001a\u00020L2\u0011\u0010M\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b4H\u0003ø\u0001\u0000¢\u0006\u0004\bN\u0010O\u001a5\u0010J\u001a\u00020.2\u0006\u0010K\u001a\u00020L2\u0006\u0010P\u001a\u00020Q2\u0011\u0010M\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b4H\u0003ø\u0001\u0000¢\u0006\u0004\bR\u0010S\u001a×\u0001\u0010T\u001a\u00020.2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020L2\u0006\u0010X\u001a\u00020L2\u0006\u0010Y\u001a\u00020L2\u0006\u0010Z\u001a\u00020?2\u0099\u0001\u0010M\u001a\u0094\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020]0\\¢\u0006\f\b^\u0012\b\b_\u0012\u0004\b\b(`\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020L0\\¢\u0006\f\b^\u0012\b\b_\u0012\u0004\b\b(a\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020L0\\¢\u0006\f\b^\u0012\b\b_\u0012\u0004\b\b(b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020]0\\¢\u0006\f\b^\u0012\b\b_\u0012\u0004\b\b(c\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020]0\\¢\u0006\f\b^\u0012\b\b_\u0012\u0004\b\b(d\u0012\u0004\u0012\u00020.0[¢\u0006\u0002\b4H\u0083\bø\u0001\u0000¢\u0006\u0004\be\u0010f\u001aH\u0010g\u001a\b\u0012\u0004\u0012\u00020h0\\2\u0006\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020?2\u0006\u0010i\u001a\u00020?2\u0006\u0010F\u001a\u00020G2\u0006\u0010j\u001a\u00020\u00032\u0006\u0010k\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0004\bl\u0010m\u001a\u0012\u0010n\u001a\u00020\u00142\b\u0010o\u001a\u0004\u0018\u00010pH\u0000\u001a\u0012\u0010q\u001a\u00020\u00142\b\u0010o\u001a\u0004\u0018\u00010pH\u0000\u001a\u001c\u0010r\u001a\u00020\b*\u00020\b2\u0006\u0010A\u001a\u00020?2\u0006\u0010s\u001a\u00020\u0001H\u0000\u001a\u001c\u0010t\u001a\u00020\b*\u00020\b2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020xH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\r\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u000e\u0010\u0005\"\u0016\u0010\u000f\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0010\u0010\u0005\"\u0016\u0010\u0011\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0012\u0010\u0005\"\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0018\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0019\u0010\u0005\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u001c\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u001d\u0010\u0005\"\u000e\u0010\u001e\u001a\u00020\u0014X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010 \u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b!\u0010\u0005\"\u000e\u0010\"\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010#\u001a\u00020$X\u0080\u0004¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&\"\u001a\u0010(\u001a\u0004\u0018\u00010)*\u00020*8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006y²\u0006\n\u0010z\u001a\u00020?X\u008a\u0084\u0002²\u0006\n\u0010{\u001a\u00020?X\u008a\u0084\u0002"}, d2 = {"ContainerId", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", "F", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "LeadingId", "MinFocusedLabelLineHeight", "getMinFocusedLabelLineHeight", "MinSupportingTextLineHeight", "getMinSupportingTextLineHeight", "MinTextLineHeight", "getMinTextLineHeight", "PlaceholderAnimationDelayOrDuration", "", "PlaceholderAnimationDuration", "PlaceholderId", "PrefixId", "PrefixSuffixTextPadding", "getPrefixSuffixTextPadding", "SuffixId", "SupportingId", "SupportingTopPadding", "getSupportingTopPadding", "TextFieldAnimationDuration", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", "type", "Landroidx/compose/material3/internal/TextFieldType;", "value", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material3/TextFieldColors;", "container", "(Landroidx/compose/material3/internal/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material3/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "content", "Decoration-Iv8Zu3U", "(JLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "Decoration-3J-VO9M", "(JLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TextFieldTransitionScope", "inputState", "Landroidx/compose/material3/internal/InputPhase;", "focusedLabelTextStyleColor", "unfocusedLabelTextStyleColor", "labelColor", "showLabel", "Lkotlin/Function5;", "Landroidx/compose/runtime/State;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "prefixSuffixOpacity", "TextFieldTransitionScope-Jy8F4Js", "(Landroidx/compose/material3/internal/InputPhase;JJJZLkotlin/jvm/functions/Function7;Landroidx/compose/runtime/Composer;I)V", "animateBorderStrokeAsState", "Landroidx/compose/foundation/BorderStroke;", "focused", "focusedBorderThickness", "unfocusedBorderThickness", "animateBorderStrokeAsState-NuRrP5Q", "(ZZZLandroidx/compose/material3/TextFieldColors;FFLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "defaultErrorSemantics", "defaultErrorMessage", "textFieldBackground", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "shape", "Landroidx/compose/ui/graphics/Shape;", "material3_release", "showPlaceholder", "showPrefixSuffix"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldImplKt {
    public static final String ContainerId = "Container";
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String PrefixId = "Prefix";
    public static final String SuffixId = "Suffix";
    public static final String SupportingId = "Supporting";
    public static final int TextFieldAnimationDuration = 150;
    public static final String TextFieldId = "TextField";
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);
    private static final float TextFieldPadding = Dp.m6693constructorimpl(16);
    private static final float HorizontalIconPadding = Dp.m6693constructorimpl(12);
    private static final float SupportingTopPadding = Dp.m6693constructorimpl(4);
    private static final float PrefixSuffixTextPadding = Dp.m6693constructorimpl(2);
    private static final float MinTextLineHeight = Dp.m6693constructorimpl(24);
    private static final float MinFocusedLabelLineHeight = Dp.m6693constructorimpl(16);
    private static final float MinSupportingTextLineHeight = Dp.m6693constructorimpl(16);
    private static final Modifier IconDefaultSizeModifier = SizeKt.m710defaultMinSizeVpY3zN4(Modifier.INSTANCE, Dp.m6693constructorimpl(48), Dp.m6693constructorimpl(48));

    /* compiled from: TextFieldImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TextFieldType.values().length];
            try {
                iArr[TextFieldType.Filled.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[TextFieldType.Outlined.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[InputPhase.values().length];
            try {
                iArr2[InputPhase.Focused.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr2[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr2[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x04bf  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x04ec  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0518  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0526  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0535  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x053b  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x053e  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x05fc  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x060a  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0619  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x061f  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0621  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0628  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0630  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0659  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0676  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x067c  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x067e  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0685  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x068d  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x073b  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0749  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0758  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x075e  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0761  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0768  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0770  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0799  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x07a7  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x07b6  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x07bc  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x07bf  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x07c6  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x07ce  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0854  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x085f  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x086e  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x0871  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0879  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x089a  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x08a8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:404:0x0909  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x0914  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0923  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x0926  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x092e  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x0957  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x0962  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x0971  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x0974  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x097c  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0a05  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x0a10  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x0a1a  */
    /* JADX WARN: Removed duplicated region for block: B:433:0x0a3b  */
    /* JADX WARN: Removed duplicated region for block: B:437:0x0a49 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:441:0x0aaa  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x0ab5  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x0abf  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x0ae8  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x0af1  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x0af9  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x0b84  */
    /* JADX WARN: Removed duplicated region for block: B:456:0x0b95  */
    /* JADX WARN: Removed duplicated region for block: B:459:0x0bf0  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x0c0a  */
    /* JADX WARN: Removed duplicated region for block: B:463:0x0c20  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x0c61  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x0c8d  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x0cab  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x0cf3  */
    /* JADX WARN: Removed duplicated region for block: B:487:0x0d3f  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x0d60  */
    /* JADX WARN: Removed duplicated region for block: B:491:0x0d64  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x0d96  */
    /* JADX WARN: Removed duplicated region for block: B:495:0x0d9a  */
    /* JADX WARN: Removed duplicated region for block: B:498:0x0dcb  */
    /* JADX WARN: Removed duplicated region for block: B:499:0x0dd2  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0dfb  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x0e11  */
    /* JADX WARN: Removed duplicated region for block: B:515:0x0ef5  */
    /* JADX WARN: Removed duplicated region for block: B:518:0x0f6b  */
    /* JADX WARN: Removed duplicated region for block: B:522:0x0f84  */
    /* JADX WARN: Removed duplicated region for block: B:524:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void CommonDecorationBox(final androidx.compose.material3.internal.TextFieldType r79, final java.lang.String r80, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r81, final androidx.compose.ui.text.input.VisualTransformation r82, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r83, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r84, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r85, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r86, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r87, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r88, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r89, boolean r90, boolean r91, boolean r92, final androidx.compose.foundation.interaction.InteractionSource r93, final androidx.compose.foundation.layout.PaddingValues r94, final androidx.compose.material3.TextFieldColors r95, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r96, androidx.compose.runtime.Composer r97, final int r98, final int r99, final int r100) {
        /*
            Method dump skipped, instructions count: 4078
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.TextFieldImplKt.CommonDecorationBox(androidx.compose.material3.internal.TextFieldType, java.lang.String, kotlin.jvm.functions.Function2, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.foundation.layout.PaddingValues, androidx.compose.material3.TextFieldColors, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final boolean CommonDecorationBox$lambda$15$lambda$7(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    private static final boolean CommonDecorationBox$lambda$15$lambda$9(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Decoration-3J-VO9M, reason: not valid java name */
    public static final void m2994Decoration3JVO9M(final long contentColor, final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Function2<? super Composer, ? super Integer, Unit> function22;
        Composer $composer2 = $composer.startRestartGroup(1208685580);
        ComposerKt.sourceInformation($composer2, "C(Decoration)P(1:c#ui.graphics.Color,2)298@12599L62:TextFieldImpl.kt#mqatfk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(contentColor) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(textStyle) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            function22 = function2;
            $dirty |= $composer2.changedInstance(function22) ? 256 : 128;
        } else {
            function22 = function2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1208685580, $dirty2, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:298)");
            }
            ProvideContentColorTextStyleKt.m2920ProvideContentColorTextStyle3JVO9M(contentColor, textStyle, function22, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$Decoration$1
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

                public final void invoke(Composer composer, int i) {
                    TextFieldImplKt.m2994Decoration3JVO9M(contentColor, textStyle, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Decoration-Iv8Zu3U, reason: not valid java name */
    public static final void m2995DecorationIv8Zu3U(final long contentColor, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(660142980);
        ComposerKt.sourceInformation($composer2, "C(Decoration)P(1:c#ui.graphics.Color)303@12806L84:TextFieldImpl.kt#mqatfk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(contentColor) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (($dirty & 19) == 18 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(660142980, $dirty, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:303)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4177boximpl(contentColor)), function2, $composer2, ProvidedValue.$stable | ($dirty & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$Decoration$2
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

                public final void invoke(Composer composer, int i) {
                    TextFieldImplKt.m2995DecorationIv8Zu3U(contentColor, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final Modifier defaultErrorSemantics(Modifier $this$defaultErrorSemantics, boolean isError, final String defaultErrorMessage) {
        return isError ? SemanticsModifierKt.semantics$default($this$defaultErrorSemantics, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt.defaultErrorSemantics.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                SemanticsPropertiesKt.error($this$semantics, defaultErrorMessage);
            }
        }, 1, null) : $this$defaultErrorSemantics;
    }

    public static final Modifier textFieldBackground(Modifier $this$textFieldBackground, final ColorProducer color, final Shape shape) {
        return DrawModifierKt.drawWithCache($this$textFieldBackground, new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.material3.internal.TextFieldImplKt.textFieldBackground.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DrawResult invoke(CacheDrawScope $this$drawWithCache) {
                final Outline outline = shape.mo278createOutlinePq9zytI($this$drawWithCache.m3835getSizeNHjbRc(), $this$drawWithCache.getLayoutDirection(), $this$drawWithCache);
                final ColorProducer colorProducer = color;
                return $this$drawWithCache.onDrawBehind(new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt.textFieldBackground.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope $this$onDrawBehind) {
                        OutlineKt.m4451drawOutlinewDX37Ww($this$onDrawBehind, outline, colorProducer.mo1537invoke0d7_KjU(), (60 & 4) != 0 ? 1.0f : 0.0f, (60 & 8) != 0 ? Fill.INSTANCE : null, (60 & 16) != 0 ? null : null, (60 & 32) != 0 ? DrawScope.INSTANCE.m4751getDefaultBlendMode0nO6VwU() : 0);
                    }
                });
            }
        });
    }

    public static final int widthOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }

    public static final int heightOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    /* renamed from: TextFieldTransitionScope-Jy8F4Js, reason: not valid java name */
    private static final void m2996TextFieldTransitionScopeJy8F4Js(InputPhase inputState, long focusedLabelTextStyleColor, long unfocusedLabelTextStyleColor, long labelColor, boolean showLabel, Function7<? super State<Float>, ? super State<Color>, ? super State<Color>, ? super State<Float>, ? super State<Float>, ? super Composer, ? super Integer, Unit> function7, Composer $composer, int $changed) {
        Transition $this$animateValue$iv$iv;
        String str;
        float f;
        InputPhase it;
        Object initialValue$iv$iv;
        float f2;
        Transition $this$animateValue$iv$iv2;
        String str2;
        float f3;
        InputPhase it2;
        Object initialValue$iv$iv2;
        float f4;
        InputPhase it3;
        Composer $composer2;
        float f5;
        Object initialValue$iv$iv3;
        InputPhase it4;
        InputPhase it5;
        Composer $composer3;
        Object value$iv$iv;
        Composer $composer4;
        Transition $this$animateValue$iv$iv3;
        InputPhase it6;
        TwoWayConverter typeConverter$iv;
        Composer $composer5;
        Object value$iv$iv2;
        Transition $this$animateValue$iv$iv4;
        ComposerKt.sourceInformationMarkerStart($composer, -1087703202, "CC(TextFieldTransitionScope)P(2,1:c#ui.graphics.Color,5:c#ui.graphics.Color,3:c#ui.graphics.Color,4)349@14528L59,352@14632L334,364@15016L1126,394@16193L363,406@16607L318,418@17028L197,424@17231L150:TextFieldImpl.kt#mqatfk");
        Transition transition = TransitionKt.updateTransition(inputState, "TextFieldInputState", $composer, ($changed & 14) | 48, 0);
        Function3 transitionSpec$iv = TextFieldImplKt$TextFieldTransitionScope$labelProgress$1.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
        TwoWayConverter typeConverter$iv$iv = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        int $changed$iv$iv = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
        ComposerKt.sourceInformationMarkerStart($composer, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
        int $changed2 = ($changed$iv$iv >> 9) & 112;
        InputPhase it7 = (InputPhase) transition.getCurrentState();
        $composer.startReplaceGroup(-2036730335);
        ComposerKt.sourceInformation($composer, "C:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            $this$animateValue$iv$iv = transition;
            str = "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli";
            ComposerKt.traceEventStart(-2036730335, $changed2, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:356)");
        } else {
            $this$animateValue$iv$iv = transition;
            str = "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli";
        }
        float f6 = 0.0f;
        switch (WhenMappings.$EnumSwitchMapping$1[it7.ordinal()]) {
            case 1:
                f = 1.0f;
                break;
            case 2:
                f = 0.0f;
                break;
            case 3:
                f = 1.0f;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        Object initialValue$iv$iv4 = Float.valueOf(f);
        int $changed3 = ($changed$iv$iv >> 9) & 112;
        InputPhase it8 = (InputPhase) $this$animateValue$iv$iv.getTargetState();
        $composer.startReplaceGroup(-2036730335);
        ComposerKt.sourceInformation($composer, "C:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            it = it8;
            initialValue$iv$iv = initialValue$iv$iv4;
            ComposerKt.traceEventStart(-2036730335, $changed3, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:356)");
        } else {
            it = it8;
            initialValue$iv$iv = initialValue$iv$iv4;
        }
        switch (WhenMappings.$EnumSwitchMapping$1[it.ordinal()]) {
            case 1:
                f2 = 1.0f;
                break;
            case 2:
                f2 = 0.0f;
                break;
            case 3:
                f2 = 1.0f;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        Object targetValue$iv$iv = Float.valueOf(f2);
        FiniteAnimationSpec<Float> animationSpec$iv$iv = transitionSpec$iv.invoke($this$animateValue$iv$iv.getSegment(), $composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
        String str3 = str;
        State labelProgress = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv, initialValue$iv$iv, targetValue$iv$iv, animationSpec$iv$iv, typeConverter$iv$iv, "LabelProgress", $composer, (($changed$iv$iv << 6) & 458752) | ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344));
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Function3 transitionSpec$iv2 = TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
        TwoWayConverter typeConverter$iv$iv2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        int $changed$iv$iv2 = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
        ComposerKt.sourceInformationMarkerStart($composer, -142660079, str3);
        int $changed4 = ($changed$iv$iv2 >> 9) & 112;
        InputPhase it9 = (InputPhase) transition.getCurrentState();
        $composer.startReplaceGroup(1435837472);
        ComposerKt.sourceInformation($composer, "C:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            $this$animateValue$iv$iv2 = transition;
            str2 = str3;
            ComposerKt.traceEventStart(1435837472, $changed4, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:386)");
        } else {
            $this$animateValue$iv$iv2 = transition;
            str2 = str3;
        }
        switch (WhenMappings.$EnumSwitchMapping$1[it9.ordinal()]) {
            case 1:
                f3 = 1.0f;
                break;
            case 2:
                if (!showLabel) {
                    f3 = 1.0f;
                    break;
                } else {
                    f3 = 0.0f;
                    break;
                }
            case 3:
                f3 = 0.0f;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        Object initialValue$iv$iv5 = Float.valueOf(f3);
        int $changed5 = ($changed$iv$iv2 >> 9) & 112;
        InputPhase it10 = (InputPhase) $this$animateValue$iv$iv2.getTargetState();
        $composer.startReplaceGroup(1435837472);
        ComposerKt.sourceInformation($composer, "C:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            it2 = it10;
            initialValue$iv$iv2 = initialValue$iv$iv5;
            ComposerKt.traceEventStart(1435837472, $changed5, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:386)");
        } else {
            it2 = it10;
            initialValue$iv$iv2 = initialValue$iv$iv5;
        }
        switch (WhenMappings.$EnumSwitchMapping$1[it2.ordinal()]) {
            case 1:
                f4 = 1.0f;
                break;
            case 2:
                if (!showLabel) {
                    f4 = 1.0f;
                    break;
                } else {
                    f4 = 0.0f;
                    break;
                }
            case 3:
                f4 = 0.0f;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        Object targetValue$iv$iv2 = Float.valueOf(f4);
        FiniteAnimationSpec<Float> animationSpec$iv$iv2 = transitionSpec$iv2.invoke($this$animateValue$iv$iv2.getSegment(), $composer, Integer.valueOf(($changed$iv$iv2 >> 3) & 112));
        String str4 = str2;
        State placeholderOpacity = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv2, initialValue$iv$iv2, targetValue$iv$iv2, animationSpec$iv$iv2, typeConverter$iv$iv2, "PlaceholderOpacity", $composer, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Function3 transitionSpec$iv3 = TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
        TwoWayConverter typeConverter$iv$iv3 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        int $changed$iv$iv3 = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
        ComposerKt.sourceInformationMarkerStart($composer, -142660079, str4);
        int $changed6 = ($changed$iv$iv3 >> 9) & 112;
        InputPhase it11 = (InputPhase) transition.getCurrentState();
        $composer.startReplaceGroup(1128033978);
        ComposerKt.sourceInformation($composer, "C:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            it3 = it11;
            $composer2 = $composer;
            ComposerKt.traceEventStart(1128033978, $changed6, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:398)");
        } else {
            it3 = it11;
            $composer2 = $composer;
        }
        switch (WhenMappings.$EnumSwitchMapping$1[it3.ordinal()]) {
            case 1:
                f5 = 1.0f;
                break;
            case 2:
                if (!showLabel) {
                    f5 = 1.0f;
                    break;
                } else {
                    f5 = 0.0f;
                    break;
                }
            case 3:
                f5 = 1.0f;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer2.endReplaceGroup();
        Object initialValue$iv$iv6 = Float.valueOf(f5);
        int $changed7 = ($changed$iv$iv3 >> 9) & 112;
        InputPhase it12 = (InputPhase) transition.getTargetState();
        $composer.startReplaceGroup(1128033978);
        ComposerKt.sourceInformation($composer, "C:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            initialValue$iv$iv3 = initialValue$iv$iv6;
            it4 = it12;
            ComposerKt.traceEventStart(1128033978, $changed7, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:398)");
        } else {
            initialValue$iv$iv3 = initialValue$iv$iv6;
            it4 = it12;
        }
        switch (WhenMappings.$EnumSwitchMapping$1[it4.ordinal()]) {
            case 1:
                f6 = 1.0f;
                break;
            case 2:
                if (!showLabel) {
                    f6 = 1.0f;
                    break;
                }
                break;
            case 3:
                f6 = 1.0f;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        Object targetValue$iv$iv3 = Float.valueOf(f6);
        FiniteAnimationSpec<Float> animationSpec$iv$iv3 = transitionSpec$iv3.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv$iv3 >> 3) & 112));
        State prefixSuffixOpacity = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv3, targetValue$iv$iv3, animationSpec$iv$iv3, typeConverter$iv$iv3, "PrefixSuffixOpacity", $composer, ($changed$iv$iv3 & 14) | (($changed$iv$iv3 << 9) & 57344) | (($changed$iv$iv3 << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Function3 transitionSpec$iv4 = TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
        int $changed8 = (384 >> 6) & 112;
        InputPhase it13 = (InputPhase) transition.getTargetState();
        $composer.startReplaceGroup(-107432127);
        ComposerKt.sourceInformation($composer, "C:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            it5 = it13;
            $composer3 = $composer;
            ComposerKt.traceEventStart(-107432127, $changed8, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:410)");
        } else {
            it5 = it13;
            $composer3 = $composer;
        }
        long j = WhenMappings.$EnumSwitchMapping$1[it5.ordinal()] == 1 ? focusedLabelTextStyleColor : unfocusedLabelTextStyleColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer3.endReplaceGroup();
        ColorSpace colorSpace$iv = Color.m4191getColorSpaceimpl(j);
        ComposerKt.sourceInformationMarkerStart($composer, 1918408083, "CC(remember):Transition.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(colorSpace$iv);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        TwoWayConverter typeConverter$iv2 = (TwoWayConverter) value$iv$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        int $changed$iv$iv4 = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
        ComposerKt.sourceInformationMarkerStart($composer, -142660079, str4);
        int $changed9 = ($changed$iv$iv4 >> 9) & 112;
        InputPhase it14 = (InputPhase) transition.getCurrentState();
        $composer.startReplaceGroup(-107432127);
        ComposerKt.sourceInformation($composer, "C:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            $composer4 = $composer;
            $this$animateValue$iv$iv3 = transition;
            ComposerKt.traceEventStart(-107432127, $changed9, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:410)");
        } else {
            $composer4 = $composer;
            $this$animateValue$iv$iv3 = transition;
        }
        long j2 = WhenMappings.$EnumSwitchMapping$1[it14.ordinal()] == 1 ? focusedLabelTextStyleColor : unfocusedLabelTextStyleColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer4.endReplaceGroup();
        Object initialValue$iv$iv7 = Color.m4177boximpl(j2);
        int $changed10 = ($changed$iv$iv4 >> 9) & 112;
        InputPhase it15 = (InputPhase) $this$animateValue$iv$iv3.getTargetState();
        $composer.startReplaceGroup(-107432127);
        ComposerKt.sourceInformation($composer, "C:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            it6 = it15;
            typeConverter$iv = typeConverter$iv2;
            ComposerKt.traceEventStart(-107432127, $changed10, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:410)");
        } else {
            it6 = it15;
            typeConverter$iv = typeConverter$iv2;
        }
        long j3 = WhenMappings.$EnumSwitchMapping$1[it6.ordinal()] == 1 ? focusedLabelTextStyleColor : unfocusedLabelTextStyleColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        Object targetValue$iv$iv4 = Color.m4177boximpl(j3);
        FiniteAnimationSpec<Color> animationSpec$iv$iv4 = transitionSpec$iv4.invoke($this$animateValue$iv$iv3.getSegment(), $composer, Integer.valueOf(($changed$iv$iv4 >> 3) & 112));
        State labelTextStyleColor = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv3, initialValue$iv$iv7, targetValue$iv$iv4, animationSpec$iv$iv4, typeConverter$iv, "LabelTextStyleColor", $composer, ($changed$iv$iv4 & 14) | (($changed$iv$iv4 << 9) & 57344) | (($changed$iv$iv4 << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Function3 transitionSpec$iv5 = TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
        int $changed11 = (384 >> 6) & 112;
        $composer.startReplaceGroup(1023351670);
        ComposerKt.sourceInformation($composer, "C:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            $composer5 = $composer;
            ComposerKt.traceEventStart(1023351670, $changed11, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:421)");
        } else {
            $composer5 = $composer;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer5.endReplaceGroup();
        ColorSpace colorSpace$iv2 = Color.m4191getColorSpaceimpl(labelColor);
        ComposerKt.sourceInformationMarkerStart($composer, 1918408083, "CC(remember):Transition.kt#9igjgp");
        boolean invalid$iv$iv2 = $composer.changed(colorSpace$iv2);
        Object it$iv$iv2 = $composer.rememberedValue();
        if (invalid$iv$iv2 || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv2);
            $composer.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        TwoWayConverter typeConverter$iv3 = (TwoWayConverter) value$iv$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        int $changed$iv$iv5 = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
        ComposerKt.sourceInformationMarkerStart($composer, -142660079, str4);
        int $changed12 = ($changed$iv$iv5 >> 9) & 112;
        $composer.startReplaceGroup(1023351670);
        ComposerKt.sourceInformation($composer, "C:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            $this$animateValue$iv$iv4 = transition;
            ComposerKt.traceEventStart(1023351670, $changed12, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:421)");
        } else {
            $this$animateValue$iv$iv4 = transition;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        Object initialValue$iv$iv8 = Color.m4177boximpl(labelColor);
        int $changed13 = ($changed$iv$iv5 >> 9) & 112;
        $composer.startReplaceGroup(1023351670);
        ComposerKt.sourceInformation($composer, "C:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1023351670, $changed13, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:421)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        Object targetValue$iv$iv5 = Color.m4177boximpl(labelColor);
        FiniteAnimationSpec<Color> animationSpec$iv$iv5 = transitionSpec$iv5.invoke($this$animateValue$iv$iv4.getSegment(), $composer, Integer.valueOf(($changed$iv$iv5 >> 3) & 112));
        State labelContentColor = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv4, initialValue$iv$iv8, targetValue$iv$iv5, animationSpec$iv$iv5, typeConverter$iv3, "LabelContentColor", $composer, (($changed$iv$iv5 << 6) & 458752) | ($changed$iv$iv5 & 14) | (($changed$iv$iv5 << 9) & 57344));
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        function7.invoke(labelProgress, labelTextStyleColor, labelContentColor, placeholderOpacity, prefixSuffixOpacity, $composer, Integer.valueOf($changed & 458752));
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    /* renamed from: animateBorderStrokeAsState-NuRrP5Q, reason: not valid java name */
    public static final State<BorderStroke> m2999animateBorderStrokeAsStateNuRrP5Q(boolean enabled, boolean isError, boolean focused, TextFieldColors colors, float focusedBorderThickness, float unfocusedBorderThickness, Composer $composer, int $changed) {
        int i;
        State stateRememberUpdatedState;
        State thickness;
        Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, 2047013045, "C(animateBorderStrokeAsState)P(1,4,2!1,3:c#ui.unit.Dp,5:c#ui.unit.Dp)458@18252L73:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2047013045, $changed, -1, "androidx.compose.material3.internal.animateBorderStrokeAsState (TextFieldImpl.kt:441)");
        }
        long targetColor = colors.m2673indicatorColorXeAY9LY$material3_release(enabled, isError, focused);
        if (enabled) {
            composer.startReplaceGroup(1023053998);
            ComposerKt.sourceInformation(composer, "445@17754L84");
            i = 0;
            stateRememberUpdatedState = SingleValueAnimationKt.m108animateColorAsStateeuL9pac(targetColor, AnimationSpecKt.tween$default(150, 0, null, 6, null), null, null, $composer, 48, 12);
            composer = $composer;
            composer.endReplaceGroup();
        } else {
            i = 0;
            composer.startReplaceGroup(1023165505);
            ComposerKt.sourceInformation(composer, "447@17868L33");
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4177boximpl(targetColor), composer, 0);
            composer.endReplaceGroup();
        }
        State indicatorColor = stateRememberUpdatedState;
        if (enabled) {
            composer.startReplaceGroup(1023269417);
            ComposerKt.sourceInformation(composer, "453@18068L85");
            float targetThickness = focused ? focusedBorderThickness : unfocusedBorderThickness;
            thickness = AnimateAsStateKt.m122animateDpAsStateAjpBEmI(targetThickness, AnimationSpecKt.tween$default(150, i, null, 6, null), null, null, composer, 48, 12);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1023478388);
            ComposerKt.sourceInformation(composer, "455@18183L46");
            thickness = SnapshotStateKt.rememberUpdatedState(Dp.m6691boximpl(unfocusedBorderThickness), composer, ($changed >> 15) & 14);
            composer.endReplaceGroup();
        }
        State<BorderStroke> stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(BorderStrokeKt.m257BorderStrokecXLIe8U(thickness.getValue().m6707unboximpl(), indicatorColor.getValue().m4197unboximpl()), composer, i);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateRememberUpdatedState2;
    }

    public static final Object getLayoutId(IntrinsicMeasurable $this$layoutId) {
        Object parentData = $this$layoutId.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    public static final float getSupportingTopPadding() {
        return SupportingTopPadding;
    }

    public static final float getPrefixSuffixTextPadding() {
        return PrefixSuffixTextPadding;
    }

    public static final float getMinTextLineHeight() {
        return MinTextLineHeight;
    }

    public static final float getMinFocusedLabelLineHeight() {
        return MinFocusedLabelLineHeight;
    }

    public static final float getMinSupportingTextLineHeight() {
        return MinSupportingTextLineHeight;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }
}
