package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: OutlinedTextField.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0087\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\b\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00132\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010-\u001a\u0093\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\b\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00132\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010.\u001a\u00020&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010/\u001a\u0087\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\b\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00132\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u00100\u001a\u0093\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\b\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00132\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010.\u001a\u00020&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u00101\u001aÁ\u0001\u00102\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\u000b0\u0018¢\u0006\u0002\b\u00192\u0019\u0010\u001a\u001a\u0015\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f¢\u0006\u0002\b\u00192\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u00105\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0006\u0010$\u001a\u00020\u00132\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u000b0\u000f2\u0011\u0010:\u001a\r\u0012\u0004\u0012\u00020\u000b0\u0018¢\u0006\u0002\b\u00192\u0006\u0010;\u001a\u00020<H\u0001¢\u0006\u0002\u0010=\u001aZ\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020&2\u0006\u0010@\u001a\u00020&2\u0006\u0010A\u001a\u00020&2\u0006\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u00020&2\u0006\u00106\u001a\u0002072\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u0002072\u0006\u0010;\u001a\u00020<H\u0002ø\u0001\u0000¢\u0006\u0004\bG\u0010H\u001aZ\u0010I\u001a\u00020&2\u0006\u0010J\u001a\u00020&2\u0006\u0010K\u001a\u00020&2\u0006\u0010L\u001a\u00020&2\u0006\u0010M\u001a\u00020&2\u0006\u0010N\u001a\u00020&2\u0006\u00106\u001a\u0002072\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u0002072\u0006\u0010;\u001a\u00020<H\u0002ø\u0001\u0000¢\u0006\u0004\bO\u0010H\u001a&\u0010P\u001a\u00020\u0011*\u00020\u00112\u0006\u0010Q\u001a\u0002092\u0006\u0010;\u001a\u00020<H\u0000ø\u0001\u0000¢\u0006\u0004\bR\u0010S\u001a|\u0010T\u001a\u00020\u000b*\u00020U2\u0006\u0010V\u001a\u00020&2\u0006\u0010W\u001a\u00020&2\b\u0010X\u001a\u0004\u0018\u00010Y2\b\u0010Z\u001a\u0004\u0018\u00010Y2\u0006\u0010[\u001a\u00020Y2\b\u0010\\\u001a\u0004\u0018\u00010Y2\b\u0010]\u001a\u0004\u0018\u00010Y2\u0006\u0010^\u001a\u00020Y2\u0006\u00106\u001a\u0002072\u0006\u0010$\u001a\u00020\u00132\u0006\u0010F\u001a\u0002072\u0006\u0010_\u001a\u00020`2\u0006\u0010;\u001a\u00020<H\u0002\u001a\u0014\u0010a\u001a\u00020&*\u00020&2\u0006\u0010b\u001a\u00020&H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006c"}, d2 = {"BorderId", "", "OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "Landroidx/compose/ui/unit/TextUnit;", "getOutlinedTextFieldTopPadding", "()J", "J", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", OutlinedTextFieldKt.BorderId, "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingPlaceableHeight", "trailingPlaceableHeight", "textFieldPlaceableHeight", "labelPlaceableHeight", "placeholderPlaceableHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-O3s9Psw", "(IIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "calculateWidth-O3s9Psw", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "height", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "borderPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "substractConstraintSafely", "from", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OutlinedTextFieldKt {
    public static final String BorderId = "border";
    private static final float OutlinedTextFieldInnerPadding = Dp.m6693constructorimpl(4);
    private static final long OutlinedTextFieldTopPadding = TextUnitKt.getSp(8);

    public static final void OutlinedTextField(final String value, final Function1<? super String, Unit> function1, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
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
        int i8;
        TextFieldColors textFieldColors;
        int $dirty1;
        Modifier.Companion modifier3;
        TextStyle textStyle3;
        int $dirty;
        Function2 label;
        Function2 placeholder;
        Function2 leadingIcon;
        Function2 trailingIcon;
        int maxLines2;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        int $dirty12;
        Composer $composer2;
        TextFieldColors colors2;
        TextStyle textStyle4;
        int $dirty2;
        boolean isError2;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean singleLine2;
        int maxLines3;
        int minLines2;
        int $dirty13;
        boolean readOnly3;
        int $dirty14;
        MutableInteractionSource interactionSource3;
        Composer $composer3;
        final boolean singleLine3;
        final VisualTransformation visualTransformation3;
        final TextFieldColors colors3;
        final boolean enabled3;
        final boolean readOnly4;
        final int maxLines4;
        final int minLines3;
        final TextStyle textStyle5;
        final Function2 label2;
        final Function2 placeholder2;
        final Function2 leadingIcon2;
        final MutableInteractionSource interactionSource4;
        final Shape shape3;
        final Modifier modifier4;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final Function2 trailingIcon2;
        final boolean isError3;
        Object value$iv;
        int $dirty15;
        Composer $composer4 = $composer.startRestartGroup(-621914704);
        ComposerKt.sourceInformation($composer4, "C(OutlinedTextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)142@7875L7,155@8525L22,156@8597L25,166@9030L7,183@9689L38,192@10056L20,200@10398L925,169@9086L2243:OutlinedTextField.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty16 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer4.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer4.changedInstance(function1) ? 32 : 16;
        }
        int i9 = i & 4;
        if (i9 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer4.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i10 = i & 8;
        if (i10 != 0) {
            $dirty3 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer4.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i11 = i & 16;
        if (i11 != 0) {
            $dirty3 |= 24576;
            readOnly2 = readOnly;
        } else if (($changed & 24576) == 0) {
            readOnly2 = readOnly;
            $dirty3 |= $composer4.changed(readOnly2) ? 16384 : 8192;
        } else {
            readOnly2 = readOnly;
        }
        if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if ((i & 32) == 0) {
                textStyle2 = textStyle;
                int i12 = $composer4.changed(textStyle2) ? 131072 : 65536;
                $dirty3 |= i12;
            } else {
                textStyle2 = textStyle;
            }
            $dirty3 |= i12;
        } else {
            textStyle2 = textStyle;
        }
        int i13 = i & 64;
        if (i13 != 0) {
            $dirty3 |= 1572864;
            function25 = function2;
        } else if (($changed & 1572864) == 0) {
            function25 = function2;
            $dirty3 |= $composer4.changedInstance(function25) ? 1048576 : 524288;
        } else {
            function25 = function2;
        }
        int i14 = i & 128;
        if (i14 != 0) {
            $dirty3 |= 12582912;
            function26 = function22;
        } else if (($changed & 12582912) == 0) {
            function26 = function22;
            $dirty3 |= $composer4.changedInstance(function26) ? 8388608 : 4194304;
        } else {
            function26 = function22;
        }
        int i15 = i & 256;
        if (i15 != 0) {
            $dirty3 |= 100663296;
            i2 = i15;
        } else if (($changed & 100663296) == 0) {
            i2 = i15;
            $dirty3 |= $composer4.changedInstance(function23) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i15;
        }
        int i16 = i & 512;
        if (i16 != 0) {
            $dirty3 |= 805306368;
            i3 = i16;
        } else if (($changed & 805306368) == 0) {
            i3 = i16;
            $dirty3 |= $composer4.changedInstance(function24) ? 536870912 : 268435456;
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
        int i20 = i & 8192;
        if (i20 != 0) {
            $dirty16 |= 3072;
            i7 = i20;
        } else {
            i7 = i20;
            if (($changed1 & 3072) == 0) {
                $dirty16 |= $composer4.changed(keyboardActions) ? 2048 : 1024;
            }
        }
        int i21 = i & 16384;
        if (i21 != 0) {
            $dirty16 |= 24576;
            i8 = i21;
        } else {
            i8 = i21;
            if (($changed1 & 24576) == 0) {
                $dirty16 |= $composer4.changed(singleLine) ? 16384 : 8192;
            }
        }
        if (($changed1 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            $dirty16 |= ((i & 32768) == 0 && $composer4.changed(maxLines)) ? 131072 : 65536;
        }
        int i22 = i & 65536;
        if (i22 != 0) {
            $dirty16 |= 1572864;
        } else if (($changed1 & 1572864) == 0) {
            $dirty16 |= $composer4.changed(minLines) ? 1048576 : 524288;
        }
        int i23 = i & 131072;
        if (i23 != 0) {
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
                int i24 = $composer4.changed(textFieldColors) ? 536870912 : 268435456;
                $dirty1 = $dirty15 | i24;
            } else {
                $dirty15 = $dirty16;
                textFieldColors = colors;
            }
            $dirty1 = $dirty15 | i24;
        } else {
            int $dirty17 = $dirty16;
            textFieldColors = colors;
            $dirty1 = $dirty17;
        }
        if (($dirty3 & 306783379) == 306783378 && ($dirty1 & 306783379) == 306783378 && $composer4.getSkipping()) {
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
            readOnly4 = readOnly2;
            textStyle5 = textStyle2;
            label2 = function25;
            placeholder2 = function26;
            modifier4 = modifier2;
            trailingIcon2 = function24;
            isError3 = isError;
            keyboardActions3 = keyboardActions;
            singleLine3 = singleLine;
        } else {
            $composer4.startDefaults();
            if (($changed & 1) == 0 || $composer4.getDefaultsInvalid()) {
                modifier3 = i9 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i10 != 0 ? true : enabled2;
                boolean readOnly5 = i11 != 0 ? false : readOnly2;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer4.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    textStyle3 = (TextStyle) objConsume;
                    $dirty = $dirty3 & (-458753);
                } else {
                    textStyle3 = textStyle2;
                    $dirty = $dirty3;
                }
                label = i13 != 0 ? null : function25;
                placeholder = i14 != 0 ? null : function26;
                leadingIcon = i2 != 0 ? null : function23;
                trailingIcon = i3 != 0 ? null : function24;
                boolean isError4 = i4 != 0 ? false : isError;
                VisualTransformation visualTransformation4 = i5 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions4 = i6 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions4 = i7 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                boolean singleLine4 = i8 != 0 ? false : singleLine;
                if ((32768 & i) != 0) {
                    $dirty1 &= -458753;
                    maxLines2 = singleLine4 ? 1 : Integer.MAX_VALUE;
                } else {
                    maxLines2 = maxLines;
                }
                int minLines4 = i22 != 0 ? 1 : minLines;
                interactionSource2 = i23 != 0 ? null : interactionSource;
                if ((262144 & i) != 0) {
                    shape2 = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape($composer4, 6);
                    $dirty12 = $dirty1 & (-234881025);
                } else {
                    shape2 = shape;
                    $dirty12 = $dirty1;
                }
                if ((i & 524288) != 0) {
                    $composer2 = $composer4;
                    colors2 = TextFieldDefaults.INSTANCE.m1720outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer4, 0, 0, 48, 2097151);
                    $dirty13 = $dirty12 & (-1879048193);
                    enabled2 = enabled4;
                    readOnly2 = readOnly5;
                    textStyle4 = textStyle3;
                    $dirty2 = $dirty;
                    isError2 = isError4;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions4;
                    keyboardActions2 = keyboardActions4;
                    singleLine2 = singleLine4;
                    maxLines3 = maxLines2;
                    minLines2 = minLines4;
                } else {
                    $composer2 = $composer4;
                    colors2 = colors;
                    enabled2 = enabled4;
                    readOnly2 = readOnly5;
                    textStyle4 = textStyle3;
                    $dirty2 = $dirty;
                    isError2 = isError4;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions4;
                    keyboardActions2 = keyboardActions4;
                    singleLine2 = singleLine4;
                    maxLines3 = maxLines2;
                    minLines2 = minLines4;
                    $dirty13 = $dirty12;
                }
            } else {
                $composer4.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((32768 & i) != 0) {
                    $dirty1 &= -458753;
                }
                if ((262144 & i) != 0) {
                    $dirty1 &= -234881025;
                }
                if ((i & 524288) != 0) {
                    leadingIcon = function23;
                    trailingIcon = function24;
                    isError2 = isError;
                    singleLine2 = singleLine;
                    maxLines3 = maxLines;
                    interactionSource2 = interactionSource;
                    shape2 = shape;
                    colors2 = colors;
                    $composer2 = $composer4;
                    $dirty2 = $dirty3;
                    textStyle4 = textStyle2;
                    label = function25;
                    placeholder = function26;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    minLines2 = minLines;
                    $dirty13 = $dirty1 & (-1879048193);
                    modifier3 = modifier2;
                    visualTransformation2 = visualTransformation;
                } else {
                    leadingIcon = function23;
                    trailingIcon = function24;
                    isError2 = isError;
                    singleLine2 = singleLine;
                    maxLines3 = maxLines;
                    interactionSource2 = interactionSource;
                    shape2 = shape;
                    colors2 = colors;
                    $composer2 = $composer4;
                    $dirty2 = $dirty3;
                    textStyle4 = textStyle2;
                    label = function25;
                    placeholder = function26;
                    modifier3 = modifier2;
                    $dirty13 = $dirty1;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    minLines2 = minLines;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                readOnly3 = readOnly2;
                ComposerKt.traceEventStart(-621914704, $dirty2, $dirty13, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:157)");
            } else {
                readOnly3 = readOnly2;
            }
            if (interactionSource2 == null) {
                $composer2.startReplaceGroup(-589524042);
                ComposerKt.sourceInformation($composer2, "159@8708L39");
                ComposerKt.sourceInformationMarkerStart($composer2, 673719756, "CC(remember):OutlinedTextField.kt#9igjgp");
                Composer $this$cache$iv = $composer2;
                Object it$iv = $this$cache$iv.rememberedValue();
                $dirty14 = $dirty13;
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = InteractionSourceKt.MutableInteractionSource();
                    $this$cache$iv.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
                interactionSource3 = (MutableInteractionSource) value$iv;
            } else {
                $dirty14 = $dirty13;
                $composer2.startReplaceGroup(673719105);
                $composer2.endReplaceGroup();
                interactionSource3 = interactionSource2;
            }
            $composer2.startReplaceGroup(673724863);
            ComposerKt.sourceInformation($composer2, "*162@8895L18");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle4.m6176getColor0d7_KjU();
            if (!($this$takeOrElse_u2dDxMtmZc$iv != 16)) {
                $this$takeOrElse_u2dDxMtmZc$iv = colors2.textColor(enabled2, $composer2, (($dirty2 >> 9) & 14) | (($dirty14 >> 24) & 112)).getValue().m4197unboximpl();
            }
            $composer2.endReplaceGroup();
            long textColor = $this$takeOrElse_u2dDxMtmZc$iv;
            TextStyle mergedTextStyle = textStyle4.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            TextStyle textStyle6 = textStyle4;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) objConsume2;
            final boolean isError5 = isError2;
            final boolean enabled5 = enabled2;
            final TextFieldColors colors4 = colors2;
            final boolean singleLine5 = singleLine2;
            final VisualTransformation visualTransformation5 = visualTransformation2;
            final MutableInteractionSource interactionSource5 = interactionSource3;
            final Function2 label3 = label;
            final Function2 placeholder3 = placeholder;
            final Function2 leadingIcon3 = leadingIcon;
            final Function2 trailingIcon3 = trailingIcon;
            final Shape shape4 = shape2;
            boolean readOnly6 = readOnly3;
            Composer $composer5 = $composer2;
            BasicTextFieldKt.BasicTextField(value, function1, SizeKt.m710defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier3.then(label != null ? PaddingKt.m685paddingqDBjuR0$default(SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                }
            }), 0.0f, density.mo362toDpGaN1DYA(OutlinedTextFieldTopPadding), 0.0f, 0.0f, 13, null) : Modifier.INSTANCE), isError2, Strings_androidKt.m1675getString4foXLRw(Strings.INSTANCE.m1670getDefaultErrorMessageUdPEhr4(), $composer2, 6)), TextFieldDefaults.INSTANCE.m1717getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1716getMinHeightD9Ej5fM()), enabled5, readOnly6, mergedTextStyle, keyboardOptions2, keyboardActions2, singleLine2, maxLines3, minLines2, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, interactionSource3, new SolidColor(colors2.cursorColor(isError2, $composer2, ($dirty14 & 14) | (($dirty14 >> 24) & 112)).getValue().m4197unboximpl(), null), ComposableLambdaKt.rememberComposableLambda(1710364390, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.3
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
                    ComposerKt.sourceInformation($composer6, "C215@11038L261,201@10448L865:OutlinedTextField.kt#jmzs0o");
                    int $dirty4 = $changed2;
                    if (($changed2 & 6) == 0) {
                        $dirty4 |= $composer6.changedInstance(function27) ? 4 : 2;
                    }
                    if (($dirty4 & 19) != 18 || !$composer6.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1710364390, $dirty4, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:201)");
                        }
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        int $dirty5 = $dirty4;
                        String str = value;
                        boolean z = enabled5;
                        boolean z2 = singleLine5;
                        VisualTransformation visualTransformation6 = visualTransformation5;
                        MutableInteractionSource mutableInteractionSource = interactionSource5;
                        boolean z3 = isError5;
                        Function2<Composer, Integer, Unit> function28 = label3;
                        Function2<Composer, Integer, Unit> function29 = placeholder3;
                        Function2<Composer, Integer, Unit> function210 = leadingIcon3;
                        Function2<Composer, Integer, Unit> function211 = trailingIcon3;
                        Shape shape5 = shape4;
                        TextFieldColors textFieldColors2 = colors4;
                        final boolean z4 = enabled5;
                        final boolean z5 = isError5;
                        final MutableInteractionSource mutableInteractionSource2 = interactionSource5;
                        final TextFieldColors textFieldColors3 = colors4;
                        final Shape shape6 = shape4;
                        textFieldDefaults.OutlinedTextFieldDecorationBox(str, function27, z, z2, visualTransformation6, mutableInteractionSource, z3, function28, function29, function210, function211, shape5, textFieldColors2, null, ComposableLambdaKt.rememberComposableLambda(1757478222, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer7, int $changed3) {
                                ComposerKt.sourceInformation($composer7, "C216@11078L203:OutlinedTextField.kt#jmzs0o");
                                if (($changed3 & 3) != 2 || !$composer7.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1757478222, $changed3, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:216)");
                                    }
                                    TextFieldDefaults.INSTANCE.m1714BorderBoxnbWgWpA(z4, z5, mutableInteractionSource2, textFieldColors3, shape6, 0.0f, 0.0f, $composer7, 12582912, 96);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer7.skipToGroupEnd();
                            }
                        }, $composer6, 54), $composer6, ($dirty5 << 3) & 112, 221184, 8192);
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
            VisualTransformation visualTransformation6 = visualTransformation2;
            singleLine3 = singleLine2;
            visualTransformation3 = visualTransformation6;
            colors3 = colors4;
            enabled3 = enabled5;
            readOnly4 = readOnly6;
            maxLines4 = maxLines3;
            minLines3 = minLines2;
            textStyle5 = textStyle6;
            label2 = label;
            placeholder2 = placeholder;
            leadingIcon2 = leadingIcon;
            interactionSource4 = interactionSource2;
            shape3 = shape2;
            modifier4 = modifier3;
            keyboardOptions3 = keyboardOptions2;
            keyboardActions3 = keyboardActions2;
            trailingIcon2 = trailingIcon;
            isError3 = isError5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.4
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

                public final void invoke(Composer composer, int i25) {
                    OutlinedTextFieldKt.OutlinedTextField(value, function1, modifier4, enabled3, readOnly4, textStyle5, label2, placeholder2, leadingIcon2, trailingIcon2, isError3, visualTransformation3, keyboardOptions3, keyboardActions3, singleLine3, maxLines4, minLines3, interactionSource4, shape3, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final /* synthetic */ void OutlinedTextField(final String value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
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
        int i8;
        TextFieldColors textFieldColors;
        int $dirty1;
        Modifier modifier3;
        TextStyle textStyle3;
        int $dirty;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        int $dirty12;
        Composer $composer2;
        Modifier modifier4;
        TextFieldColors colors2;
        TextStyle textStyle4;
        int $dirty2;
        Function2 label2;
        Function2 placeholder2;
        Function2 leadingIcon2;
        Function2 trailingIcon2;
        boolean isError2;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean singleLine2;
        int maxLines2;
        MutableInteractionSource interactionSource3;
        Shape shape3;
        int $dirty13;
        Object value$iv;
        final Modifier modifier5;
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
        final KeyboardActions keyboardActions3;
        final boolean singleLine3;
        final int maxLines3;
        final MutableInteractionSource interactionSource4;
        final Shape shape4;
        final TextFieldColors colors3;
        int $dirty14;
        Composer $composer3 = $composer.startRestartGroup(-2099955827);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)240@11690L7,251@12250L39,252@12328L22,253@12400L25,255@12434L416:OutlinedTextField.kt#jmzs0o");
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
        int i9 = i & 4;
        if (i9 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i10 = i & 8;
        if (i10 != 0) {
            $dirty3 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer3.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i11 = i & 16;
        if (i11 != 0) {
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
                int i12 = $composer3.changed(textStyle2) ? 131072 : 65536;
                $dirty3 |= i12;
            } else {
                textStyle2 = textStyle;
            }
            $dirty3 |= i12;
        } else {
            textStyle2 = textStyle;
        }
        int i13 = i & 64;
        if (i13 != 0) {
            $dirty3 |= 1572864;
            function2 = label;
        } else if (($changed & 1572864) == 0) {
            function2 = label;
            $dirty3 |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        } else {
            function2 = label;
        }
        int i14 = i & 128;
        if (i14 != 0) {
            $dirty3 |= 12582912;
            function22 = placeholder;
        } else if (($changed & 12582912) == 0) {
            function22 = placeholder;
            $dirty3 |= $composer3.changedInstance(function22) ? 8388608 : 4194304;
        } else {
            function22 = placeholder;
        }
        int i15 = i & 256;
        if (i15 != 0) {
            $dirty3 |= 100663296;
            i2 = i15;
        } else if (($changed & 100663296) == 0) {
            i2 = i15;
            $dirty3 |= $composer3.changedInstance(leadingIcon) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i15;
        }
        int i16 = i & 512;
        if (i16 != 0) {
            $dirty3 |= 805306368;
            i3 = i16;
        } else if (($changed & 805306368) == 0) {
            i3 = i16;
            $dirty3 |= $composer3.changedInstance(trailingIcon) ? 536870912 : 268435456;
        } else {
            i3 = i16;
        }
        int i17 = i & 1024;
        if (i17 != 0) {
            $dirty15 |= 6;
            i4 = i17;
        } else if (($changed1 & 6) == 0) {
            i4 = i17;
            $dirty15 |= $composer3.changed(isError) ? 4 : 2;
        } else {
            i4 = i17;
        }
        int i18 = i & 2048;
        if (i18 != 0) {
            $dirty15 |= 48;
            i5 = i18;
        } else if (($changed1 & 48) == 0) {
            i5 = i18;
            $dirty15 |= $composer3.changed(visualTransformation) ? 32 : 16;
        } else {
            i5 = i18;
        }
        int i19 = i & 4096;
        if (i19 != 0) {
            $dirty15 |= 384;
            i6 = i19;
        } else {
            i6 = i19;
            if (($changed1 & 384) == 0) {
                $dirty15 |= $composer3.changed(keyboardOptions) ? 256 : 128;
            }
        }
        int i20 = i & 8192;
        if (i20 != 0) {
            $dirty15 |= 3072;
            i7 = i20;
        } else {
            i7 = i20;
            if (($changed1 & 3072) == 0) {
                $dirty15 |= $composer3.changed(keyboardActions) ? 2048 : 1024;
            }
        }
        int i21 = i & 16384;
        if (i21 != 0) {
            $dirty15 |= 24576;
            i8 = i21;
        } else {
            i8 = i21;
            if (($changed1 & 24576) == 0) {
                $dirty15 |= $composer3.changed(singleLine) ? 16384 : 8192;
            }
        }
        int i22 = i & 32768;
        if (i22 != 0) {
            $dirty15 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed1 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            $dirty15 |= $composer3.changed(maxLines) ? 131072 : 65536;
        }
        int i23 = i & 65536;
        if (i23 != 0) {
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
                int i24 = $composer3.changed(textFieldColors) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
                $dirty1 = $dirty14 | i24;
            } else {
                $dirty14 = $dirty15;
                textFieldColors = colors;
            }
            $dirty1 = $dirty14 | i24;
        } else {
            int $dirty16 = $dirty15;
            textFieldColors = colors;
            $dirty1 = $dirty16;
        }
        if (($dirty3 & 306783379) == 306783378 && ($dirty1 & 38347923) == 38347922 && $composer3.getSkipping()) {
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
            modifier5 = modifier2;
            label4 = trailingIcon;
            isError3 = isError;
            keyboardActions3 = keyboardActions;
            singleLine3 = singleLine;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier6 = i9 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i10 != 0 ? true : enabled2;
                boolean readOnly4 = i11 != 0 ? false : readOnly2;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    modifier3 = modifier6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle3 = (TextStyle) objConsume;
                    $dirty = $dirty3 & (-458753);
                } else {
                    modifier3 = modifier6;
                    textStyle3 = textStyle2;
                    $dirty = $dirty3;
                }
                Function2 label5 = i13 != 0 ? null : function2;
                Function2 placeholder4 = i14 != 0 ? null : function22;
                Function2 leadingIcon4 = i2 != 0 ? null : leadingIcon;
                Function2 trailingIcon3 = i3 != 0 ? null : trailingIcon;
                boolean isError4 = i4 != 0 ? false : isError;
                VisualTransformation visualTransformation4 = i5 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions4 = i6 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions4 = i7 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                boolean singleLine4 = i8 != 0 ? false : singleLine;
                int maxLines4 = i22 != 0 ? Integer.MAX_VALUE : maxLines;
                if (i23 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, 673833100, "CC(remember):OutlinedTextField.kt#9igjgp");
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
                    shape2 = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape($composer3, 6);
                    $dirty12 = $dirty1 & (-29360129);
                } else {
                    shape2 = shape;
                    $dirty12 = $dirty1;
                }
                if ((i & 262144) != 0) {
                    $composer2 = $composer3;
                    modifier4 = modifier3;
                    textStyle4 = textStyle3;
                    enabled2 = enabled4;
                    colors2 = TextFieldDefaults.INSTANCE.m1720outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 0, 0, 48, 2097151);
                    $dirty13 = $dirty12 & (-234881025);
                    readOnly2 = readOnly4;
                    $dirty2 = $dirty;
                    label2 = label5;
                    placeholder2 = placeholder4;
                    leadingIcon2 = leadingIcon4;
                    trailingIcon2 = trailingIcon3;
                    isError2 = isError4;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions4;
                    keyboardActions2 = keyboardActions4;
                    singleLine2 = singleLine4;
                    maxLines2 = maxLines4;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                } else {
                    $composer2 = $composer3;
                    modifier4 = modifier3;
                    colors2 = colors;
                    textStyle4 = textStyle3;
                    enabled2 = enabled4;
                    readOnly2 = readOnly4;
                    $dirty2 = $dirty;
                    label2 = label5;
                    placeholder2 = placeholder4;
                    leadingIcon2 = leadingIcon4;
                    trailingIcon2 = trailingIcon3;
                    isError2 = isError4;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions4;
                    keyboardActions2 = keyboardActions4;
                    singleLine2 = singleLine4;
                    maxLines2 = maxLines4;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                    $dirty13 = $dirty12;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i & 131072) != 0) {
                    $dirty1 &= -29360129;
                }
                if ((i & 262144) != 0) {
                    int i25 = $dirty1 & (-234881025);
                    leadingIcon2 = leadingIcon;
                    trailingIcon2 = trailingIcon;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    singleLine2 = singleLine;
                    maxLines2 = maxLines;
                    interactionSource3 = interactionSource;
                    shape3 = shape;
                    $dirty13 = i25;
                    $composer2 = $composer3;
                    $dirty2 = $dirty3;
                    colors2 = textFieldColors;
                    textStyle4 = textStyle2;
                    label2 = function2;
                    placeholder2 = function22;
                    modifier4 = modifier2;
                    isError2 = isError;
                    visualTransformation2 = visualTransformation;
                } else {
                    leadingIcon2 = leadingIcon;
                    trailingIcon2 = trailingIcon;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    singleLine2 = singleLine;
                    maxLines2 = maxLines;
                    shape3 = shape;
                    $composer2 = $composer3;
                    $dirty2 = $dirty3;
                    colors2 = textFieldColors;
                    textStyle4 = textStyle2;
                    label2 = function2;
                    placeholder2 = function22;
                    modifier4 = modifier2;
                    $dirty13 = $dirty1;
                    isError2 = isError;
                    visualTransformation2 = visualTransformation;
                    interactionSource3 = interactionSource;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2099955827, $dirty2, $dirty13, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:254)");
            }
            OutlinedTextField(value, (Function1<? super String, Unit>) onValueChange, modifier4, enabled2, readOnly2, textStyle4, (Function2<? super Composer, ? super Integer, Unit>) label2, (Function2<? super Composer, ? super Integer, Unit>) placeholder2, (Function2<? super Composer, ? super Integer, Unit>) leadingIcon2, (Function2<? super Composer, ? super Integer, Unit>) trailingIcon2, isError2, visualTransformation2, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, 1, interactionSource3, shape3, colors2, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | (57344 & $dirty2) | (458752 & $dirty2) | (3670016 & $dirty2) | (29360128 & $dirty2) | (234881024 & $dirty2) | (1879048192 & $dirty2), ($dirty13 & 14) | 1572864 | ($dirty13 & 112) | ($dirty13 & 896) | ($dirty13 & 7168) | (57344 & $dirty13) | (458752 & $dirty13) | (($dirty13 << 3) & 29360128) | (($dirty13 << 3) & 234881024) | (($dirty13 << 3) & 1879048192), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
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
            keyboardActions3 = keyboardActions2;
            singleLine3 = singleLine2;
            maxLines3 = maxLines2;
            interactionSource4 = interactionSource3;
            shape4 = shape3;
            colors3 = colors2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.6
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

                public final void invoke(Composer composer, int i26) {
                    OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier5, enabled3, readOnly3, textStyle5, label3, placeholder3, leadingIcon3, label4, isError3, visualTransformation3, keyboardOptions3, keyboardActions3, singleLine3, maxLines3, interactionSource4, shape4, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void OutlinedTextField(final TextFieldValue value, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
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
        Modifier.Companion modifier3;
        int i8;
        int $dirty;
        TextStyle textStyle3;
        Function2 label;
        Function2 placeholder;
        Function2 leadingIcon;
        Function2 trailingIcon;
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
        boolean isError2;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        boolean singleLine2;
        int maxLines3;
        int minLines2;
        int $dirty14;
        boolean readOnly3;
        int $dirty15;
        MutableInteractionSource interactionSource3;
        TextStyle mergedTextStyle;
        Modifier.Companion companionM685paddingqDBjuR0$default;
        Composer $composer3;
        final boolean singleLine3;
        final VisualTransformation visualTransformation3;
        final TextStyle textStyle5;
        final TextFieldColors colors3;
        final boolean enabled3;
        final boolean readOnly4;
        final int maxLines4;
        final int minLines3;
        final Function2 label2;
        final Function2 placeholder2;
        final Function2 leadingIcon2;
        final MutableInteractionSource interactionSource4;
        final Shape shape3;
        final Modifier modifier4;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions4;
        final Function2 trailingIcon2;
        final boolean isError3;
        Object value$iv;
        int $dirty16;
        Composer $composer4 = $composer.startRestartGroup(237745923);
        ComposerKt.sourceInformation($composer4, "C(OutlinedTextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)351@17754L7,364@18398L22,365@18470L25,375@18903L7,392@19562L38,401@19929L20,409@20271L930,378@18959L2248:OutlinedTextField.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty17 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer4.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer4.changedInstance(function1) ? 32 : 16;
        }
        int i9 = i & 4;
        if (i9 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer4.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i10 = i & 8;
        if (i10 != 0) {
            $dirty3 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer4.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i11 = i & 16;
        if (i11 != 0) {
            $dirty3 |= 24576;
            readOnly2 = readOnly;
        } else if (($changed & 24576) == 0) {
            readOnly2 = readOnly;
            $dirty3 |= $composer4.changed(readOnly2) ? 16384 : 8192;
        } else {
            readOnly2 = readOnly;
        }
        if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if ((i & 32) == 0) {
                textStyle2 = textStyle;
                int i12 = $composer4.changed(textStyle2) ? 131072 : 65536;
                $dirty3 |= i12;
            } else {
                textStyle2 = textStyle;
            }
            $dirty3 |= i12;
        } else {
            textStyle2 = textStyle;
        }
        int i13 = i & 64;
        if (i13 != 0) {
            $dirty3 |= 1572864;
            function25 = function2;
        } else if (($changed & 1572864) == 0) {
            function25 = function2;
            $dirty3 |= $composer4.changedInstance(function25) ? 1048576 : 524288;
        } else {
            function25 = function2;
        }
        int i14 = i & 128;
        if (i14 != 0) {
            $dirty3 |= 12582912;
            function26 = function22;
        } else if (($changed & 12582912) == 0) {
            function26 = function22;
            $dirty3 |= $composer4.changedInstance(function26) ? 8388608 : 4194304;
        } else {
            function26 = function22;
        }
        int i15 = i & 256;
        if (i15 != 0) {
            $dirty3 |= 100663296;
            i2 = i15;
        } else if (($changed & 100663296) == 0) {
            i2 = i15;
            $dirty3 |= $composer4.changedInstance(function23) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i15;
        }
        int i16 = i & 512;
        if (i16 != 0) {
            $dirty3 |= 805306368;
            i3 = i16;
        } else if (($changed & 805306368) == 0) {
            i3 = i16;
            $dirty3 |= $composer4.changedInstance(function24) ? 536870912 : 268435456;
        } else {
            i3 = i16;
        }
        int i17 = i & 1024;
        if (i17 != 0) {
            $dirty17 |= 6;
            i4 = i17;
        } else if (($changed1 & 6) == 0) {
            i4 = i17;
            $dirty17 |= $composer4.changed(isError) ? 4 : 2;
        } else {
            i4 = i17;
        }
        int i18 = i & 2048;
        if (i18 != 0) {
            $dirty17 |= 48;
            i5 = i18;
        } else if (($changed1 & 48) == 0) {
            i5 = i18;
            $dirty17 |= $composer4.changed(visualTransformation) ? 32 : 16;
        } else {
            i5 = i18;
        }
        int i19 = i & 4096;
        if (i19 != 0) {
            $dirty17 |= 384;
            i6 = i19;
        } else {
            i6 = i19;
            if (($changed1 & 384) == 0) {
                $dirty17 |= $composer4.changed(keyboardOptions) ? 256 : 128;
            }
        }
        if (($changed1 & 3072) == 0) {
            $dirty17 |= ((i & 8192) == 0 && $composer4.changed(keyboardActions)) ? 2048 : 1024;
        }
        int i20 = i & 16384;
        if (i20 != 0) {
            $dirty17 |= 24576;
            i7 = i20;
        } else {
            i7 = i20;
            if (($changed1 & 24576) == 0) {
                $dirty17 |= $composer4.changed(singleLine) ? 16384 : 8192;
            }
        }
        if (($changed1 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            $dirty17 |= ((i & 32768) == 0 && $composer4.changed(maxLines)) ? 131072 : 65536;
        }
        int i21 = i & 65536;
        if (i21 != 0) {
            $dirty17 |= 1572864;
        } else if (($changed1 & 1572864) == 0) {
            $dirty17 |= $composer4.changed(minLines) ? 1048576 : 524288;
        }
        int i22 = i & 131072;
        if (i22 != 0) {
            $dirty17 |= 12582912;
        } else if (($changed1 & 12582912) == 0) {
            $dirty17 |= $composer4.changed(interactionSource) ? 8388608 : 4194304;
        }
        if (($changed1 & 100663296) == 0) {
            $dirty17 |= ((i & 262144) == 0 && $composer4.changed(shape)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed1 & 805306368) == 0) {
            if ((i & 524288) == 0) {
                $dirty16 = $dirty17;
                textFieldColors = colors;
                int i23 = $composer4.changed(textFieldColors) ? 536870912 : 268435456;
                $dirty1 = $dirty16 | i23;
            } else {
                $dirty16 = $dirty17;
                textFieldColors = colors;
            }
            $dirty1 = $dirty16 | i23;
        } else {
            int $dirty18 = $dirty17;
            textFieldColors = colors;
            $dirty1 = $dirty18;
        }
        int $dirty4 = $dirty3;
        if (($dirty3 & 306783379) == 306783378 && (306783379 & $dirty1) == 306783378 && $composer4.getSkipping()) {
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
            readOnly4 = readOnly2;
            textStyle5 = textStyle2;
            label2 = function25;
            placeholder2 = function26;
            modifier4 = modifier2;
            trailingIcon2 = function24;
            isError3 = isError;
            keyboardActions4 = keyboardActions;
            singleLine3 = singleLine;
        } else {
            $composer4.startDefaults();
            if (($changed & 1) == 0 || $composer4.getDefaultsInvalid()) {
                modifier3 = i9 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i10 != 0 ? true : enabled2;
                boolean readOnly5 = i11 != 0 ? false : readOnly2;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    i8 = -458753;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer4.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    textStyle3 = (TextStyle) objConsume;
                    $dirty = $dirty4 & (-458753);
                } else {
                    i8 = -458753;
                    $dirty = $dirty4;
                    textStyle3 = textStyle2;
                }
                label = i13 != 0 ? null : function25;
                placeholder = i14 != 0 ? null : function26;
                leadingIcon = i2 != 0 ? null : function23;
                trailingIcon = i3 != 0 ? null : function24;
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
                if ((32768 & i) != 0) {
                    $dirty12 &= i8;
                    maxLines2 = singleLine4 ? 1 : Integer.MAX_VALUE;
                } else {
                    maxLines2 = maxLines;
                }
                int minLines4 = i21 != 0 ? 1 : minLines;
                interactionSource2 = i22 != 0 ? null : interactionSource;
                if ((262144 & i) != 0) {
                    shape2 = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape($composer4, 6);
                    $dirty13 = $dirty12 & (-234881025);
                } else {
                    shape2 = shape;
                    $dirty13 = $dirty12;
                }
                if ((i & 524288) != 0) {
                    TextFieldColors colors4 = TextFieldDefaults.INSTANCE.m1720outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer4, 0, 0, 48, 2097151);
                    $composer2 = $composer4;
                    keyboardActions3 = keyboardActions2;
                    $dirty14 = $dirty13 & (-1879048193);
                    enabled2 = enabled4;
                    readOnly2 = readOnly5;
                    textStyle4 = textStyle3;
                    $dirty2 = $dirty;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions4;
                    singleLine2 = singleLine4;
                    maxLines3 = maxLines2;
                    minLines2 = minLines4;
                    colors2 = colors4;
                    isError2 = isError4;
                } else {
                    $composer2 = $composer4;
                    colors2 = colors;
                    keyboardActions3 = keyboardActions2;
                    enabled2 = enabled4;
                    readOnly2 = readOnly5;
                    textStyle4 = textStyle3;
                    $dirty2 = $dirty;
                    isError2 = isError4;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions4;
                    singleLine2 = singleLine4;
                    maxLines3 = maxLines2;
                    minLines2 = minLines4;
                    $dirty14 = $dirty13;
                }
            } else {
                $composer4.skipToGroupEnd();
                int $dirty5 = (i & 32) != 0 ? $dirty4 & (-458753) : $dirty4;
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
                singleLine2 = singleLine;
                maxLines3 = maxLines;
                interactionSource2 = interactionSource;
                shape2 = shape;
                colors2 = colors;
                $dirty14 = $dirty1;
                $composer2 = $composer4;
                textStyle4 = textStyle2;
                label = function25;
                placeholder = function26;
                keyboardOptions2 = keyboardOptions;
                keyboardActions3 = keyboardActions;
                minLines2 = minLines;
                $dirty2 = $dirty5;
                modifier3 = modifier2;
                visualTransformation2 = visualTransformation;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                readOnly3 = readOnly2;
                ComposerKt.traceEventStart(237745923, $dirty2, $dirty14, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:366)");
            } else {
                readOnly3 = readOnly2;
            }
            if (interactionSource2 == null) {
                $composer2.startReplaceGroup(-579730026);
                ComposerKt.sourceInformation($composer2, "368@18581L39");
                ComposerKt.sourceInformationMarkerStart($composer2, 674035692, "CC(remember):OutlinedTextField.kt#9igjgp");
                Composer $this$cache$iv = $composer2;
                Object it$iv = $this$cache$iv.rememberedValue();
                $dirty15 = $dirty14;
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = InteractionSourceKt.MutableInteractionSource();
                    $this$cache$iv.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
                interactionSource3 = (MutableInteractionSource) value$iv;
            } else {
                $dirty15 = $dirty14;
                $composer2.startReplaceGroup(674035041);
                $composer2.endReplaceGroup();
                interactionSource3 = interactionSource2;
            }
            $composer2.startReplaceGroup(674040799);
            ComposerKt.sourceInformation($composer2, "*371@18768L18");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle4.m6176getColor0d7_KjU();
            if (!($this$takeOrElse_u2dDxMtmZc$iv != 16)) {
                $this$takeOrElse_u2dDxMtmZc$iv = colors2.textColor(enabled2, $composer2, (($dirty2 >> 9) & 14) | (($dirty15 >> 24) & 112)).getValue().m4197unboximpl();
            }
            $composer2.endReplaceGroup();
            long textColor = $this$takeOrElse_u2dDxMtmZc$iv;
            TextStyle mergedTextStyle2 = textStyle4.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            TextStyle textStyle6 = textStyle4;
            final boolean enabled5 = enabled2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) objConsume2;
            if (label != null) {
                mergedTextStyle = mergedTextStyle2;
                companionM685paddingqDBjuR0$default = PaddingKt.m685paddingqDBjuR0$default(SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.7
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    }
                }), 0.0f, density.mo362toDpGaN1DYA(OutlinedTextFieldTopPadding), 0.0f, 0.0f, 13, null);
            } else {
                mergedTextStyle = mergedTextStyle2;
                companionM685paddingqDBjuR0$default = Modifier.INSTANCE;
            }
            Modifier modifierM710defaultMinSizeVpY3zN4 = SizeKt.m710defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier3.then(companionM685paddingqDBjuR0$default), isError2, Strings_androidKt.m1675getString4foXLRw(Strings.INSTANCE.m1670getDefaultErrorMessageUdPEhr4(), $composer2, 6)), TextFieldDefaults.INSTANCE.m1717getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1716getMinHeightD9Ej5fM());
            SolidColor solidColor = new SolidColor(colors2.cursorColor(isError2, $composer2, ($dirty15 & 14) | (($dirty15 >> 24) & 112)).getValue().m4197unboximpl(), null);
            final boolean isError5 = isError2;
            final TextFieldColors colors5 = colors2;
            final boolean singleLine5 = singleLine2;
            final VisualTransformation visualTransformation5 = visualTransformation2;
            final MutableInteractionSource interactionSource5 = interactionSource3;
            final Function2 label3 = label;
            final Function2 placeholder3 = placeholder;
            final Function2 leadingIcon3 = leadingIcon;
            final Function2 trailingIcon3 = trailingIcon;
            final Shape shape4 = shape2;
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1001528775, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.9
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

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function27, Composer $composer5, int $changed2) {
                    ComposerKt.sourceInformation($composer5, "C424@20916L261,410@20321L870:OutlinedTextField.kt#jmzs0o");
                    int $dirty6 = $changed2;
                    if (($changed2 & 6) == 0) {
                        $dirty6 |= $composer5.changedInstance(function27) ? 4 : 2;
                    }
                    if (($dirty6 & 19) == 18 && $composer5.getSkipping()) {
                        $composer5.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1001528775, $dirty6, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:410)");
                    }
                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                    String text = value.getText();
                    boolean z = enabled5;
                    int $dirty7 = $dirty6;
                    boolean z2 = singleLine5;
                    VisualTransformation visualTransformation6 = visualTransformation5;
                    MutableInteractionSource mutableInteractionSource = interactionSource5;
                    boolean z3 = isError5;
                    Function2<Composer, Integer, Unit> function28 = label3;
                    Function2<Composer, Integer, Unit> function29 = placeholder3;
                    Function2<Composer, Integer, Unit> function210 = leadingIcon3;
                    Function2<Composer, Integer, Unit> function211 = trailingIcon3;
                    Shape shape5 = shape4;
                    TextFieldColors textFieldColors2 = colors5;
                    final boolean z4 = enabled5;
                    final boolean z5 = isError5;
                    final MutableInteractionSource mutableInteractionSource2 = interactionSource5;
                    final TextFieldColors textFieldColors3 = colors5;
                    final Shape shape6 = shape4;
                    textFieldDefaults.OutlinedTextFieldDecorationBox(text, function27, z, z2, visualTransformation6, mutableInteractionSource, z3, function28, function29, function210, function211, shape5, textFieldColors2, null, ComposableLambdaKt.rememberComposableLambda(-794566495, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.9.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer6, int $changed3) {
                            ComposerKt.sourceInformation($composer6, "C425@20956L203:OutlinedTextField.kt#jmzs0o");
                            if (($changed3 & 3) != 2 || !$composer6.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-794566495, $changed3, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:425)");
                                }
                                TextFieldDefaults.INSTANCE.m1714BorderBoxnbWgWpA(z4, z5, mutableInteractionSource2, textFieldColors3, shape6, 0.0f, 0.0f, $composer6, 12582912, 96);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer6.skipToGroupEnd();
                        }
                    }, $composer5, 54), $composer5, ($dirty7 << 3) & 112, 221184, 8192);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54);
            int i24 = ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 7168) | (57344 & $dirty2) | (($dirty15 << 12) & 3670016) | (($dirty15 << 12) & 29360128) | (($dirty15 << 12) & 234881024) | (1879048192 & ($dirty15 << 12));
            int i25 = (($dirty15 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ($dirty15 & 112);
            boolean readOnly6 = readOnly3;
            Composer $composer5 = $composer2;
            BasicTextFieldKt.BasicTextField(value, function1, modifierM710defaultMinSizeVpY3zN4, enabled5, readOnly6, mergedTextStyle, keyboardOptions2, keyboardActions3, singleLine2, maxLines3, minLines2, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, interactionSource3, solidColor, composableLambdaRememberComposableLambda, $composer5, i24, i25, 4096);
            $composer3 = $composer5;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            VisualTransformation visualTransformation6 = visualTransformation2;
            singleLine3 = singleLine2;
            visualTransformation3 = visualTransformation6;
            textStyle5 = textStyle6;
            colors3 = colors5;
            enabled3 = enabled5;
            readOnly4 = readOnly6;
            maxLines4 = maxLines3;
            minLines3 = minLines2;
            label2 = label;
            placeholder2 = placeholder;
            leadingIcon2 = leadingIcon;
            interactionSource4 = interactionSource2;
            shape3 = shape2;
            modifier4 = modifier3;
            keyboardOptions3 = keyboardOptions2;
            keyboardActions4 = keyboardActions3;
            trailingIcon2 = trailingIcon;
            isError3 = isError5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.10
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

                public final void invoke(Composer composer, int i26) {
                    OutlinedTextFieldKt.OutlinedTextField(value, function1, modifier4, enabled3, readOnly4, textStyle5, label2, placeholder2, leadingIcon2, trailingIcon2, isError3, visualTransformation3, keyboardOptions3, keyboardActions4, singleLine3, maxLines4, minLines3, interactionSource4, shape3, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final /* synthetic */ void OutlinedTextField(final TextFieldValue value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
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
        Composer $composer3 = $composer.startRestartGroup(-288998816);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)449@21584L7,460@22138L39,461@22216L22,462@22288L25,464@22322L416:OutlinedTextField.kt#jmzs0o");
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
                    ComposerKt.sourceInformationMarkerStart($composer3, 674149516, "CC(remember):OutlinedTextField.kt#9igjgp");
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
                    shape2 = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape($composer3, 6);
                    $dirty13 = $dirty12 & (-29360129);
                } else {
                    shape2 = shape;
                    $dirty13 = $dirty12;
                }
                if ((i & 262144) != 0) {
                    $composer2 = $composer3;
                    keyboardActions3 = keyboardActions2;
                    modifier3 = modifier5;
                    colors2 = TextFieldDefaults.INSTANCE.m1720outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 0, 0, 48, 2097151);
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
                ComposerKt.traceEventStart(-288998816, $dirty2, $dirty1, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:463)");
            }
            OutlinedTextField(value, (Function1<? super TextFieldValue, Unit>) onValueChange, modifier3, enabled2, readOnly2, textStyle4, (Function2<? super Composer, ? super Integer, Unit>) label2, (Function2<? super Composer, ? super Integer, Unit>) placeholder2, (Function2<? super Composer, ? super Integer, Unit>) leadingIcon2, (Function2<? super Composer, ? super Integer, Unit>) trailingIcon2, isError2, visualTransformation2, keyboardOptions2, keyboardActions3, singleLine2, maxLines2, 1, interactionSource3, shape3, colors2, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | (57344 & $dirty2) | (458752 & $dirty2) | (3670016 & $dirty2) | (29360128 & $dirty2) | (234881024 & $dirty2) | (1879048192 & $dirty2), ($dirty1 & 14) | 1572864 | ($dirty1 & 112) | ($dirty1 & 896) | ($dirty1 & 7168) | (57344 & $dirty1) | (458752 & $dirty1) | (($dirty1 << 3) & 29360128) | (($dirty1 << 3) & 234881024) | (($dirty1 << 3) & 1879048192), 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.12
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
                    OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier4, enabled3, readOnly3, textStyle5, label3, placeholder3, leadingIcon3, label4, isError3, visualTransformation3, keyboardOptions3, keyboardActions4, singleLine3, maxLines3, interactionSource4, shape4, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void OutlinedTextFieldLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final boolean singleLine, final float animationProgress, final Function1<? super Size, Unit> function1, final Function2<? super Composer, ? super Integer, Unit> function25, final PaddingValues paddingValues, Composer $composer, final int $changed, final int $changed1) {
        Function0 factory$iv$iv;
        Composer $composer2;
        float f;
        float f2;
        Function0 factory$iv$iv$iv;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function0 factory$iv$iv$iv2;
        int $changed$iv;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Composer $composer3 = $composer.startRestartGroup(-2049536174);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextFieldLayout)P(4,9,7,2,3,10,8!1,5)508@23459L239,516@23746L7,517@23758L2308:OutlinedTextField.kt#jmzs0o");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function23) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function24) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer3.changed(singleLine) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changed(animationProgress) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changedInstance(function25) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changed(paddingValues) ? 4 : 2;
        }
        if (($dirty & 306783379) != 306783378 || ($dirty1 & 3) != 2 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2049536174, $dirty, $dirty1, "androidx.compose.material.OutlinedTextFieldLayout (OutlinedTextField.kt:507)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -1860606082, "CC(remember):OutlinedTextField.kt#9igjgp");
            int $dirty2 = $dirty;
            boolean invalid$iv = ((234881024 & $dirty) == 67108864) | (($dirty2 & 3670016) == 1048576) | (($dirty2 & 29360128) == 8388608) | (($dirty1 & 14) == 4);
            Object value$iv = $composer3.rememberedValue();
            if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new OutlinedTextFieldMeasurePolicy(function1, singleLine, animationProgress, paddingValues);
                $composer3.updateRememberedValue(value$iv);
            }
            OutlinedTextFieldMeasurePolicy measurePolicy = (OutlinedTextFieldMeasurePolicy) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume;
            int $changed$iv2 = ($dirty2 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer3, modifier);
            Function0 factory$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv = (($changed$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv = factory$iv$iv2;
                $composer3.createNode(factory$iv$iv);
            } else {
                factory$iv$iv = factory$iv$iv2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m3678constructorimpl($composer3);
            $composer2 = $composer3;
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), block$iv$iv);
            }
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -988650720, "C525@24262L8,564@25710L182:OutlinedTextField.kt#jmzs0o");
            function25.invoke($composer2, Integer.valueOf(($dirty2 >> 27) & 14));
            if (function23 != null) {
                $composer2.startReplaceGroup(-988654503);
                ComposerKt.sourceInformation($composer2, "528@24323L219");
                Modifier modifier$iv = LayoutIdKt.layoutId(Modifier.INSTANCE, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv5;
                    $composer2.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv5;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer2);
                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                }
                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i2 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int i3 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 1888671661, "C532@24515L9:OutlinedTextField.kt#jmzs0o");
                function23.invoke($composer2, Integer.valueOf(($dirty2 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-988413292);
                $composer2.endReplaceGroup();
            }
            if (function24 != null) {
                $composer2.startReplaceGroup(-988370729);
                ComposerKt.sourceInformation($composer2, "536@24609L221");
                Modifier modifier$iv2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv3 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer2.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3678constructorimpl($composer2);
                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2 block$iv$iv$iv2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), block$iv$iv$iv2);
                }
                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                int i5 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 1888956396, "C540@24802L10:OutlinedTextField.kt#jmzs0o");
                function24.invoke($composer2, Integer.valueOf(($dirty2 >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-988127596);
                $composer2.endReplaceGroup();
            }
            float startTextFieldPadding = PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
            float endTextFieldPadding = PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
            Modifier.Companion companion = Modifier.INSTANCE;
            if (function23 != null) {
                float other$iv = TextFieldImplKt.getHorizontalIconPadding();
                float other$iv2 = Dp.m6693constructorimpl(startTextFieldPadding - other$iv);
                float minimumValue$iv = Dp.m6693constructorimpl(0);
                float $this$coerceAtLeast_u2dYgX7TsA$iv = Dp.m6693constructorimpl(RangesKt.coerceAtLeast(other$iv2, minimumValue$iv));
                f = $this$coerceAtLeast_u2dYgX7TsA$iv;
            } else {
                f = startTextFieldPadding;
            }
            if (function24 != null) {
                float other$iv3 = TextFieldImplKt.getHorizontalIconPadding();
                float other$iv4 = Dp.m6693constructorimpl(endTextFieldPadding - other$iv3);
                float minimumValue$iv2 = Dp.m6693constructorimpl(0);
                float $this$coerceAtLeast_u2dYgX7TsA$iv2 = Dp.m6693constructorimpl(RangesKt.coerceAtLeast(other$iv4, minimumValue$iv2));
                f2 = $this$coerceAtLeast_u2dYgX7TsA$iv2;
            } else {
                f2 = endTextFieldPadding;
            }
            Modifier padding = PaddingKt.m685paddingqDBjuR0$default(companion, f, 0.0f, f2, 0.0f, 10, null);
            if (function3 != null) {
                $composer2.startReplaceGroup(-987369863);
                ComposerKt.sourceInformation($composer2, "561@25623L59");
                function3.invoke(LayoutIdKt.layoutId(Modifier.INSTANCE, "Hint").then(padding), $composer2, Integer.valueOf(($dirty2 >> 3) & 112));
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-987282412);
                $composer2.endReplaceGroup();
            }
            Modifier modifier$iv3 = LayoutIdKt.layoutId(Modifier.INSTANCE, "TextField").then(padding);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, true);
            int $changed$iv$iv4 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv7;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv7;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3678constructorimpl($composer2);
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), block$iv$iv$iv3);
            }
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
            int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            int i7 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1890012907, "C568@25867L11:OutlinedTextField.kt#jmzs0o");
            function2.invoke($composer2, Integer.valueOf(($dirty2 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (function22 != null) {
                $composer2.startReplaceGroup(-987052578);
                ComposerKt.sourceInformation($composer2, "572@25943L54");
                Modifier modifier$iv4 = LayoutIdKt.layoutId(Modifier.INSTANCE, "Label");
                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv4 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv4, false);
                int $changed$iv$iv5 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv4 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer2, modifier$iv4);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv5 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv8;
                    $composer2.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv8;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3678constructorimpl($composer2);
                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2 block$iv$iv$iv4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv4.getInserting()) {
                    $changed$iv = 6;
                } else {
                    $changed$iv = 6;
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                    }
                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                    int i8 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    int i9 = (($changed$iv >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1890132815, "C572@25988L7:OutlinedTextField.kt#jmzs0o");
                    function26 = function22;
                    function26.invoke($composer2, Integer.valueOf(($dirty2 >> 9) & 14));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endReplaceGroup();
                }
                $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), block$iv$iv$iv4);
                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                int i82 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance42 = BoxScopeInstance.INSTANCE;
                int i92 = (($changed$iv >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 1890132815, "C572@25988L7:OutlinedTextField.kt#jmzs0o");
                function26 = function22;
                function26.invoke($composer2, Integer.valueOf(($dirty2 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            } else {
                function26 = function22;
                $composer2.startReplaceGroup(-986969932);
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            function26 = function22;
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextFieldLayout.2
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

                public final void invoke(Composer composer, int i10) {
                    OutlinedTextFieldKt.OutlinedTextFieldLayout(modifier, function2, function3, function27, function23, function24, singleLine, animationProgress, function1, function25, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int substractConstraintSafely(int $this$substractConstraintSafely, int from) {
        if ($this$substractConstraintSafely == Integer.MAX_VALUE) {
            return $this$substractConstraintSafely;
        }
        return $this$substractConstraintSafely - from;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-O3s9Psw, reason: not valid java name */
    public static final int m1615calculateWidthO3s9Psw(int leadingPlaceableWidth, int trailingPlaceableWidth, int textFieldPlaceableWidth, int labelPlaceableWidth, int placeholderPlaceableWidth, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        int middleSection = Math.max(textFieldPlaceableWidth, Math.max(MathHelpersKt.lerp(labelPlaceableWidth, 0, animationProgress), placeholderPlaceableWidth));
        int wrappedWidth = leadingPlaceableWidth + middleSection + trailingPlaceableWidth;
        float arg0$iv = paddingValues.mo632calculateLeftPaddingu2uoSUM(LayoutDirection.Ltr);
        float other$iv = paddingValues.mo633calculateRightPaddingu2uoSUM(LayoutDirection.Ltr);
        float labelHorizontalPadding = Dp.m6693constructorimpl(arg0$iv + other$iv) * density;
        int focusedLabelWidth = MathKt.roundToInt((labelPlaceableWidth + labelHorizontalPadding) * animationProgress);
        return Math.max(wrappedWidth, Math.max(focusedLabelWidth, Constraints.m6638getMinWidthimpl(constraints)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-O3s9Psw, reason: not valid java name */
    public static final int m1614calculateHeightO3s9Psw(int leadingPlaceableHeight, int trailingPlaceableHeight, int textFieldPlaceableHeight, int labelPlaceableHeight, int placeholderPlaceableHeight, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        int inputFieldHeight = Math.max(textFieldPlaceableHeight, Math.max(placeholderPlaceableHeight, MathHelpersKt.lerp(labelPlaceableHeight, 0, animationProgress)));
        float topPadding = paddingValues.getTop() * density;
        float actualTopPadding = MathHelpersKt.lerp(topPadding, Math.max(topPadding, labelPlaceableHeight / 2.0f), animationProgress);
        float bottomPadding = paddingValues.getBottom() * density;
        float middleSectionHeight = inputFieldHeight + actualTopPadding + bottomPadding;
        return Math.max(Constraints.m6637getMinHeightimpl(constraints), Math.max(leadingPlaceableHeight, Math.max(trailingPlaceableHeight, MathKt.roundToInt(middleSectionHeight))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope $this$place, int height, int width, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable textFieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable borderPlaceable, float animationProgress, boolean singleLine, float density, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        int iAlign;
        int iAlign2;
        int startPositionY;
        float fWidthOrZero;
        int topPadding = MathKt.roundToInt(paddingValues.getTop() * density);
        int startPadding = MathKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * density);
        float iconPadding = TextFieldImplKt.getHorizontalIconPadding() * density;
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, leadingPlaceable, 0, Alignment.INSTANCE.getCenterVertically().align(leadingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.INSTANCE.getCenterVertically().align(trailingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (labelPlaceable != null) {
            if (singleLine) {
                startPositionY = Alignment.INSTANCE.getCenterVertically().align(labelPlaceable.getHeight(), height);
            } else {
                startPositionY = topPadding;
            }
            int positionY = MathHelpersKt.lerp(startPositionY, -(labelPlaceable.getHeight() / 2), animationProgress);
            if (leadingPlaceable == null) {
                fWidthOrZero = 0.0f;
            } else {
                fWidthOrZero = (TextFieldImplKt.widthOrZero(leadingPlaceable) - iconPadding) * (1.0f - animationProgress);
            }
            int positionX = MathKt.roundToInt(fWidthOrZero) + startPadding;
            Placeable.PlacementScope.placeRelative$default($this$place, labelPlaceable, positionX, positionY, 0.0f, 4, null);
        }
        if (singleLine) {
            iAlign = Alignment.INSTANCE.getCenterVertically().align(textFieldPlaceable.getHeight(), height);
        } else {
            iAlign = topPadding;
        }
        int textVerticalPosition = Math.max(iAlign, TextFieldImplKt.heightOrZero(labelPlaceable) / 2);
        Placeable.PlacementScope.placeRelative$default($this$place, textFieldPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textVerticalPosition, 0.0f, 4, null);
        if (placeholderPlaceable != null) {
            if (singleLine) {
                iAlign2 = Alignment.INSTANCE.getCenterVertically().align(placeholderPlaceable.getHeight(), height);
            } else {
                iAlign2 = topPadding;
            }
            int placeholderVerticalPosition = Math.max(iAlign2, TextFieldImplKt.heightOrZero(labelPlaceable) / 2);
            Placeable.PlacementScope.placeRelative$default($this$place, placeholderPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), placeholderVerticalPosition, 0.0f, 4, null);
        }
        Placeable.PlacementScope.m5605place70tqf50$default($this$place, borderPlaceable, IntOffset.INSTANCE.m6835getZeronOccac(), 0.0f, 2, null);
    }

    /* renamed from: outlineCutout-12SF9DM, reason: not valid java name */
    public static final Modifier m1616outlineCutout12SF9DM(Modifier $this$outlineCutout_u2d12SF9DM, final long labelSize, final PaddingValues paddingValues) {
        return DrawModifierKt.drawWithContent($this$outlineCutout_u2d12SF9DM, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$outlineCutout$1

            /* compiled from: OutlinedTextField.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LayoutDirection.values().length];
                    try {
                        iArr[LayoutDirection.Rtl.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) throws Throwable {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope $this$drawWithContent) throws Throwable {
                float right;
                float labelWidth = Size.m4014getWidthimpl(labelSize);
                if (labelWidth > 0.0f) {
                    float innerPadding = $this$drawWithContent.mo367toPx0680j_4(OutlinedTextFieldKt.OutlinedTextFieldInnerPadding);
                    float leftLtr = $this$drawWithContent.mo367toPx0680j_4(paddingValues.mo632calculateLeftPaddingu2uoSUM($this$drawWithContent.getLayoutDirection())) - innerPadding;
                    float rightLtr = leftLtr + labelWidth + (2.0f * innerPadding);
                    float left = WhenMappings.$EnumSwitchMapping$0[$this$drawWithContent.getLayoutDirection().ordinal()] == 1 ? Size.m4014getWidthimpl($this$drawWithContent.mo4662getSizeNHjbRc()) - rightLtr : RangesKt.coerceAtLeast(leftLtr, 0.0f);
                    if (WhenMappings.$EnumSwitchMapping$0[$this$drawWithContent.getLayoutDirection().ordinal()] == 1) {
                        right = Size.m4014getWidthimpl($this$drawWithContent.mo4662getSizeNHjbRc()) - RangesKt.coerceAtLeast(leftLtr, 0.0f);
                    } else {
                        right = rightLtr;
                    }
                    float labelHeight = Size.m4011getHeightimpl(labelSize);
                    ContentDrawScope $this$clipRect_u2drOu3jXo$iv = $this$drawWithContent;
                    float top$iv = (-labelHeight) / 2.0f;
                    float bottom$iv = labelHeight / 2.0f;
                    int clipOp$iv = ClipOp.INSTANCE.m4175getDifferencertfAjoo();
                    DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$clipRect_u2drOu3jXo$iv.getDrawContext();
                    long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.mo4669getSizeNHjbRc();
                    $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
                    try {
                        DrawTransform $this$clipRect_rOu3jXo_u24lambda_u244$iv = $this$withTransform_u24lambda_u246$iv$iv.getTransform();
                        try {
                            $this$clipRect_rOu3jXo_u24lambda_u244$iv.mo4672clipRectN_I0leg(left, top$iv, right, bottom$iv, clipOp$iv);
                            $this$drawWithContent.drawContent();
                            $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                            $this$withTransform_u24lambda_u246$iv$iv.mo4670setSizeuvyYCjk(previousSize$iv$iv);
                        } catch (Throwable th) {
                            th = th;
                            $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform_u24lambda_u246$iv$iv;
                            $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                            $this$withTransform_u24lambda_u246$iv$iv.mo4670setSizeuvyYCjk(previousSize$iv$iv);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    $this$drawWithContent.drawContent();
                }
            }
        });
    }

    public static final long getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
    }
}
